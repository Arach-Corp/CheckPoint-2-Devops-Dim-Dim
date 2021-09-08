package br.com.dimdim.dimdim.config;

import br.com.dimdim.dimdim.entities.Movimentacao;
import br.com.dimdim.dimdim.entities.Usuario;
import br.com.dimdim.dimdim.repositories.MovimentacaoRepository;
import br.com.dimdim.dimdim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@gmail.com");
        usuario.setPassword("teste123");
        usuario.setSaldo(BigDecimal.ZERO);
        usuarioRepository.save(usuario);


        Movimentacao mov = new Movimentacao();
        mov.setDescricao("Compras Amazon");
        mov.setValor(BigDecimal.valueOf(-200.89));
        Movimentacao mov2 = new Movimentacao();
        mov2.setDescricao("Pix");
        mov2.setValor(BigDecimal.valueOf(300));

        usuario.addMovimentacao(mov);
        usuario.addMovimentacao(mov2);

        movimentacaoRepository.saveAll(Arrays.asList(mov, mov2));
        usuarioRepository.save(usuario);

    }
}
