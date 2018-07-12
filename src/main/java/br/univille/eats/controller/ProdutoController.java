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

import br.univille.eats.model.Estabelecimento;
import br.univille.eats.model.Produto;
import br.univille.eats.repository.EstabRepository;
import br.univille.eats.repository.ProdRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdRepository prodRepository;
	
	@Autowired
	private EstabRepository estabRepository; 

	@GetMapping("")
	public ModelAndView index() {
		List<Produto> listaProd = this.prodRepository.findAll();

		return new ModelAndView("produto/index","listaProd",listaProd);
	}
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Produto produto) {
		List<Estabelecimento> listaEstab = estabRepository.findAll();
		return new ModelAndView("produto/form", "listaEstab", listaEstab);
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes redirect) {

		produto = this.prodRepository.save(produto);

		return new ModelAndView("redirect:/produto");
	}

	@GetMapping(value="/alterar/{idProd}")
	public ModelAndView alterarForm(@PathVariable("idProd") Produto prod) {
		List<Estabelecimento> listaEstab = estabRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("produto", prod);
		dados.put("estabelecimento", listaEstab);
		return new ModelAndView("produto/form","produto",prod);
	}

	@GetMapping(value="remover/{idProd}")
	public ModelAndView remover(@PathVariable ("idProd") Long id, RedirectAttributes redirect) {
		this.prodRepository.deleteById(id);
		return new ModelAndView("redirect:/produto");
	}
}