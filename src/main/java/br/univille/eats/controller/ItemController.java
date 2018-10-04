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
import br.univille.eats.model.Item;
import br.univille.eats.model.Produto;
import br.univille.eats.repository.EstabRepository;
import br.univille.eats.repository.ItemRepository;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private EstabRepository estabRepository; 

	@GetMapping("")
	public ModelAndView index() {
		List<Item> listaItem = this.itemRepository.findAll();

		return new ModelAndView("item/index","listaItem",listaItem);
	}
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Item item) {
		List<Estabelecimento> listaEstab = estabRepository.findAll();
		return new ModelAndView("item/form", "listaEstab", listaEstab);
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Item item, BindingResult result, RedirectAttributes redirect) {

		item = this.itemRepository.save(item);

		return new ModelAndView("redirect:/item");
	}

	@GetMapping(value="/alterar/{idItem}")
	public ModelAndView alterarForm(@PathVariable("idItem") Item item) {
		List<Estabelecimento> listaItem = estabRepository.findAll();
		return new ModelAndView("item/form","item",listaItem);
	}

	@GetMapping(value="remover/{idItem}")
	public ModelAndView remover(@PathVariable ("idItem") Long id, RedirectAttributes redirect) {
		this.itemRepository.deleteById(id);
		return new ModelAndView("redirect:/item");
	}
}