package br.univille.eats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.eats.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}