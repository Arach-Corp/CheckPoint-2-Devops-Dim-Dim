package br.com.dimdim.dimdim.services;

import br.com.dimdim.dimdim.entities.Movimentacao;
import br.com.dimdim.dimdim.entities.Usuario;
import br.com.dimdim.dimdim.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario register(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.getById(id);
    }

    public Page<Usuario> findAllUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public void addMovimentacao(Usuario usuario, Movimentacao movimentacao) {
        usuario.addMovimentacao(movimentacao);
    }

}
