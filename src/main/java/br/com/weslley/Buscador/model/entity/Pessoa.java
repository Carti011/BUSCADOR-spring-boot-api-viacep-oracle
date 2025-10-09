package br.com.weslley.Buscador.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_PESSOAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToOne // Indica que é um relacionamento 1:1
    @JoinColumn(name = "endereco_cep_fk") // O nome da coluna FK na tabela TB_PESSOAS
    private Endereco endereco; // A referência é para o objeto Endereco inteiro
}