package br.com.weslley.Buscador.service;

import br.com.weslley.Buscador.dto.PessoaDTO;
import br.com.weslley.Buscador.model.entity.Endereco;
import br.com.weslley.Buscador.model.entity.Pessoa;
import br.com.weslley.Buscador.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Pessoa cadastrarPessoa(PessoaDTO pessoaDTO) {
        // O PessoaService DELEGA a busca do endereço para o EnderecoService.
        Endereco endereco = enderecoService.buscarOuCriarEndereco(pessoaDTO.cep());

        // O PessoaService foca no seu próprio trabalho: criar a Pessoa.
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setEmail(pessoaDTO.email());
        pessoa.setEndereco(endereco); // Associa o endereço encontrado.

        return pessoaRepository.save(pessoa);
    }
}