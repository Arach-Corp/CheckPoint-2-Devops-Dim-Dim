package br.com.dimdim.dimdim.services;

import br.com.dimdim.dimdim.entities.Movimentacao;
import br.com.dimdim.dimdim.entities.Usuario;
import br.com.dimdim.dimdim.repositories.MovimentacaoRepository;
import br.com.dimdim.dimdim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Usuario register(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.getById(id);
    }

    public Page<Usuario> findAllUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Transactional
    public void addMovimentacao(Usuario usuario, Movimentacao movimentacao) {
        usuario.addMovimentacao(movimentacao);
        movimentacaoRepository.save(movimentacao);
        usuarioRepository.save(usuario);
    }

    public Page<Movimentacao> getAllMovimentacaoByUser(Usuario usuario, Pageable pageable){
        return movimentacaoRepository.findAllByUsuarioOrderByDataMovimentacaoDesc(usuario, pageable);
    }

}
