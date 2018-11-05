package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	Cidade findById(long id);

}