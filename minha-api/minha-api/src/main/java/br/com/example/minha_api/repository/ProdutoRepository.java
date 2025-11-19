package br.com.example.minha_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.example.minha_api.model.ProdutoModelo;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModelo, Long> {

}
