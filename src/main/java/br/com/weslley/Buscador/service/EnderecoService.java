package br.com.weslley.Buscador.service;

import br.com.weslley.Buscador.client.ViaCepClient;
import br.com.weslley.Buscador.dto.ViaCepResponseDTO;
import br.com.weslley.Buscador.model.entity.Endereco;
import br.com.weslley.Buscador.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Esta é uma classe de Serviço
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepClient viaCepClient; // Injetamos o cliente da API


    /**
     * Este metodo é a lógica central. Ele verifica se um endereço já existe no
     * banco de dados pelo CEP. Se não existir, ele busca na API do ViaCEP,
     * salva no banco (criando um cache) e depois retorna.
     * @param cep O CEP a ser buscado.
     * @return A entidade Endereco correspondente.
     */
    public Endereco buscarOuCriarEndereco(String cep) {
        // Usa o metodo findById do repositório. Se ele não encontrar nada,
        // o .orElseGet() executa o código para buscar na API externa.
        return enderecoRepository.findById(cep).orElseGet(() -> {
            // Busca na API do ViaCEP usando nosso cliente Feign
            ViaCepResponseDTO viaCepResponseDTO = viaCepClient.buscaEnderecoPorCep(cep);

            // Converte o DTO retornado pela API para a nossa entidade Endereco
            Endereco novoEndereco = new Endereco();
            novoEndereco.setCep(viaCepResponseDTO.cep());
            novoEndereco.setLogradouro(viaCepResponseDTO.logradouro());
            novoEndereco.setBairro(viaCepResponseDTO.bairro());
            novoEndereco.setLocalidade(viaCepResponseDTO.localidade());
            novoEndereco.setUf(viaCepResponseDTO.uf());

            // Salva no nosso banco e o retorna
            return enderecoRepository.save(novoEndereco);
        });
    }
}
