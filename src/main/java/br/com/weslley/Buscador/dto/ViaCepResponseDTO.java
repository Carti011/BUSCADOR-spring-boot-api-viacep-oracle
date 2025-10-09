package br.com.weslley.Buscador.dto;

import jakarta.validation.constraints.NotNull;

public record ViaCepResponseDTO(
        @NotNull
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}