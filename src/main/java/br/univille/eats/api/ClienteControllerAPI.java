package br.univille.eats.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.eats.model.Cliente;
import br.univille.eats.repository.ClienteRepository;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteControllerAPI {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> lista = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente Cliente){
		clienteRepository.save(Cliente);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody Cliente newCliente){
		Optional<Cliente> talvezCliente = clienteRepository.findById(id);
		if (!talvezCliente.isPresent())
			return ResponseEntity.notFound().build();
		
		Cliente oldCliente = talvezCliente.get();
		
		oldCliente.setNome(newCliente.getNome());
		//oldCliente.setSexo(newCliente.getSexo());
		
		clienteRepository.save(oldCliente);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Optional<Cliente> talvezCliente = clienteRepository.findById(id);
		if (!talvezCliente.isPresent())
			return ResponseEntity.notFound().build();
		
		clienteRepository.delete(talvezCliente.get());
		
		return ResponseEntity.ok().build();
	}
}
