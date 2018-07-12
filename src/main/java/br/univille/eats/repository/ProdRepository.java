package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.Produto;

@Repository
public interface ProdRepository extends JpaRepository<Produto, Long>{

}
