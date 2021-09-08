package br.com.dimdim.dimdim.config;

import br.com.dimdim.dimdim.entities.Usuario;
import br.com.dimdim.dimdim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@gmail.com");
        usuario.setPassword("teste123");
        usuario.setSaldo(BigDecimal.ZERO);
        usuarioRepository.save(usuario);
    }
}
