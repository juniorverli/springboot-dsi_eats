package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}