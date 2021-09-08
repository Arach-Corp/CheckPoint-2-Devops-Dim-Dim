package br.com.dimdim.dimdim.repositories;

import br.com.dimdim.dimdim.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
