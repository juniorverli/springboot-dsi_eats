package br.univille.eats.controller;

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
import br.univille.eats.repository.CardapioRepository;

@Controller
@RequestMapping("/cardapio")

public class CardapioController {
	
	@Autowired
    private CardapioRepository cardapioRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Cardapio> listaCardapio= this.cardapioRepository.findAll();
       
        return new ModelAndView("cardapio/index","listaCardapio",listaCardapio);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute Cardapio cardapio) {
    	return "cardapio/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Cardapio cardapio, BindingResult result, RedirectAttributes redirect) {        
    	cardapio = this.cardapioRepository.save(cardapio);
        return new ModelAndView("redirect:/cardapio");
    }
    @GetMapping(value="/alterar/{idCardapio}")
    public ModelAndView alterarForm(@PathVariable("idCardapio") Cardapio cardapio) {
        return new ModelAndView("cardapio/form","cardapio",cardapio);
    }
    @GetMapping(value="remover/{idCardapio}")
    public ModelAndView remover(@PathVariable ("idCardapio") Long id, RedirectAttributes redirect) {
        this.cardapioRepository.deleteById(id);
        return new ModelAndView("redirect:/cardapio");
    }
}