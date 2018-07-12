package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.eats.model.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long>{

}