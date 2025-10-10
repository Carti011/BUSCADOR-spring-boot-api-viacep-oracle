package br.com.weslley.Buscador.client;

import br.com.weslley.Buscador.dto.ViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json") // Continuidade da URL da API
    ViaCepResponseDTO buscaEnderecoPorCep(@PathVariable("cep") String cep); // Path troca {cep} pelo valor digitado

}
