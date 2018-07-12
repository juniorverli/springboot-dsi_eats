package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.Estabelecimento;

@Repository
public interface EstabRepository extends JpaRepository<Estabelecimento, Long>{

}
