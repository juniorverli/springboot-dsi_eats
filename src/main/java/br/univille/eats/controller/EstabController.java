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
import br.univille.eats.model.Estabelecimento;
import br.univille.eats.repository.CidadeRepository;
import br.univille.eats.repository.EstabRepository;

@Controller
@RequestMapping("/estabelecimento")
public class EstabController {
	
	@Autowired
	private EstabRepository estabRepository; 
	@Autowired
	private CidadeRepository cidadeRepository; 

	@GetMapping("")
	public ModelAndView index() {
		List<Estabelecimento> listaEstabelecimento = this.estabRepository.findAll();

		return new ModelAndView("estabelecimento/index","listaestab",listaEstabelecimento);
	}
	@GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Estabelecimento estabelecimento) {
        List<Cidade> listaCidades = cidadeRepository.findAll();
        return new ModelAndView("estabelecimento/form","listaCidades",listaCidades);
    }
	@PostMapping(params="form")
    public ModelAndView save(@Valid Estabelecimento estabelecimento, BindingResult result, RedirectAttributes redirect) {
        
        estabelecimento = this.estabRepository.save(estabelecimento);
        
        return new ModelAndView("redirect:/estabelecimento");
    }
	
	@GetMapping(value="/alterar/{idEstab}")
    public ModelAndView alterarForm(@PathVariable("idEstab") Estabelecimento estabelecimento) {
		List<Cidade> listaCidades = cidadeRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("estabelecimento",estabelecimento);
        dados.put("listaCidades",listaCidades);
        
        return new ModelAndView("estabelecimento/form",dados);
    }
	
	@GetMapping(value="remover/{idEstab}")
    public ModelAndView remover(@PathVariable ("idEstab") Long id, RedirectAttributes redirect) {
        this.estabRepository.deleteById(id);
        return new ModelAndView("redirect:/estabelecimento");
    }
}