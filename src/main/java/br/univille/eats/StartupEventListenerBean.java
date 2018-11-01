package br.univille.eats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.eats.model.Cidade;
import br.univille.eats.model.Pagamento;
import br.univille.eats.model.Usuario;
import br.univille.eats.repository.CidadeRepository;
import br.univille.eats.repository.PagamentoRepository;
import br.univille.eats.repository.UsuarioRepository;

@Component
public class StartupEventListenerBean {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if(cidadeRepository.findByNome("cidade") == null) {
			Cidade cidade = new Cidade();
			cidade.setNome("Joinville");
			cidade.setEstado("SC");
			cidadeRepository.save(cidade);
		}

		if(usuarioRepository.findByUsername("user") == null) {
			Usuario user = new Usuario();
			user.setUsername("admin");
			user.setPassword("admin");
			user.setRole("ROLE_ADMIN");
			usuarioRepository.save(user);
		}

		if(pagamentoRepository.findById(1) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(2) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Débito");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(3) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Crédito");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(4) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Vale Alimentação");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(5) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Vale Refeição");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(6) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro/Débito");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(7) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro/Crédito");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(8) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro/Vale Alimentação");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(9) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro/Vale Refeição");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(10) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Débito/Crédito");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(11) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Débito/Vale Alimentação");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(12) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Débito/Vale Refeição");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(13) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Crédito/Vale Alimentação");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(14) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Crédito/Vale Refeição");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(15) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Vale Alimentação/Vale Refeição");
			pagamentoRepository.save(pay);
		}
		if(pagamentoRepository.findById(16) == null) {
			Pagamento pay = new Pagamento();
			pay.setPay("Dinheiro/Débito/Crédito");
			pagamentoRepository.save(pay);
		}
		
	}

}