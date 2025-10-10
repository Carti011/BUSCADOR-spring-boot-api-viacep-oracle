package br.com.weslley.Buscador.controller;

import br.com.weslley.Buscador.model.entity.Endereco;
import br.com.weslley.Buscador.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}") // Dentro das {} Variavel passada no caminho Path
    public ResponseEntity<Endereco> buscarEnderecoPorCep(@PathVariable String cep) {
        try {
            Endereco endereco = enderecoService.buscarOuCriarEndereco(cep);
            return ResponseEntity.ok(endereco); // Retorna 200 OK com o endereço no corpo
        } catch (Exception e) {
            // Se o FeignClient não encontrar o CEP, ele lança uma exceção
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

}
