package br.univille.eats.controller;


import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.eats.model.Cidade;
import br.univille.eats.model.Cliente;
import br.univille.eats.repository.CidadeRepository;
import br.univille.eats.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private CidadeRepository cidadeRepository; 

	@GetMapping("")
	public ModelAndView index() {
		List<Cliente> listaCliente = this.clienteRepository.findAll();

		return new ModelAndView("cliente/index","listaclientes",listaCliente);
	}
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cliente cliente) {
		List<Cidade> listaCidades = cidadeRepository.findAll();
        return new ModelAndView("cliente/form","listaCidades",listaCidades);
    }
	@PostMapping(params="form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
        
        cliente = this.clienteRepository.save(cliente);
        
        return new ModelAndView("redirect:/cliente");
    }
	
	@GetMapping(value="/alterar/{idCliente}")
    public ModelAndView alterarForm(@PathVariable("idCliente") Cliente cliente) {
		List<Cidade> listaCidades = cidadeRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("cliente",cliente);
        dados.put("listaCidades",listaCidades);
        
        return new ModelAndView("cliente/form",dados);
    }
	
	@GetMapping(value="remover/{idCliente}")
    public ModelAndView remover(@PathVariable ("idCliente") Long id, RedirectAttributes redirect) {
        this.clienteRepository.deleteById(id);
        return new ModelAndView("redirect:/cliente");
    }
}