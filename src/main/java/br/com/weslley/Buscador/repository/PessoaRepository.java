package br.com.weslley.Buscador.repository;

import br.com.weslley.Buscador.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
