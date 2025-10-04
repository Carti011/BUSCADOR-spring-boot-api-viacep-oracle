package br.com.weslley.Buscador.dto;

public record ViaCepResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}