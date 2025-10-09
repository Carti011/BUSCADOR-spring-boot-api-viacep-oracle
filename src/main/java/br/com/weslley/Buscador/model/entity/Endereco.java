package br.com.weslley.Buscador.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TB_ENDERECOS")
@Getter
@Setter
@NoArgsConstructor // Gera o construtor vazio (sem argumentos)
@AllArgsConstructor // Gera um construtor com todos os argumentos
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
