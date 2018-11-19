package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.ItensCardapio;

@Repository
public interface ItensCardapioRepository extends JpaRepository<ItensCardapio, Long>{

}
