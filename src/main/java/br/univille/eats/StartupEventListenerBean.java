package br.univille.eats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.eats.model.Usuario;
import br.univille.eats.model.Cidade;
import br.univille.eats.repository.CidadeRepository;
import br.univille.eats.repository.UsuarioRepository;

@Component
public class StartupEventListenerBean {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

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

    }
}