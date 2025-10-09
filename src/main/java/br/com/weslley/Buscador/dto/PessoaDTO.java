package br.com.weslley.Buscador.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8, max = 9)
        String cep
) {
}