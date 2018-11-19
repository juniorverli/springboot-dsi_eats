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

import br.univille.eats.model.Cardapio;
import br.univille.eats.model.Estabelecimento;
import br.univille.eats.model.ItensCardapio;
import br.univille.eats.repository.CardapioRepository;
import br.univille.eats.repository.EstabRepository;
import br.univille.eats.repository.ItensCardapioRepository;
import br.univille.eats.repository.ProdRepository;


@Controller
@RequestMapping("/itenscardapio")
public class ItensCardapioController {

	@Autowired
	private ItensCardapioRepository itenscardapioRepository;

	@Autowired
	private CardapioRepository cardapioRepository;

	@Autowired
	private EstabRepository estabRepository; 
	
	@Autowired
	private ProdRepository prodRepository; 

	@GetMapping("")
	public ModelAndView index() {
		List<ItensCardapio> listaItensCardapio= this.itenscardapioRepository.findAll();

		return new ModelAndView("itenscardapio/index","listaItensCardapio",listaItensCardapio);
	}
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute ItensCardapio itenscardapio) {
		List<Estabelecimento> listaEstab = estabRepository.findAll();
		return new ModelAndView("itenscardapio/form", "itenscardapio", itenscardapio);
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid ItensCardapio itenscardapio, BindingResult result, RedirectAttributes redirect) {

		itenscardapio = this.itenscardapioRepository.save(itenscardapio);

		return new ModelAndView("redirect:/itenscardapio");
	}

	@GetMapping(value="/alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") ItensCardapio produto) {
		List<Estabelecimento> listaEstab = estabRepository.findAll();
		List<Cardapio> listaCardapio = cardapioRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("produto", produto);
		dados.put("estabelecimento", listaEstab);
		dados.put("cardapio", listaCardapio);
		return new ModelAndView("itenscardapio/form","produto",produto);
	}

	@GetMapping(value="remover/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
		this.itenscardapioRepository.deleteById(id);
		return new ModelAndView("redirect:/itenscardapio");
	}
}