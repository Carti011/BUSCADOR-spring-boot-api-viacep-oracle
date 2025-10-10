package br.com.weslley.Buscador.controller;

import br.com.weslley.Buscador.dto.PessoaDTO;
import br.com.weslley.Buscador.model.entity.Pessoa;
import br.com.weslley.Buscador.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService; // O Controller depende do Service

    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        try {
            Pessoa pessoa = pessoaService.cadastrarPessoa(pessoaDTO); // Comando para cadastrar Pessoa
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoa); // retorna 201 e body o corpo Json da pessoa

        } catch (Exception e) {
            // Erro retorna 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

}