package br.com.weslley.Buscador.repository;

import br.com.weslley.Buscador.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
