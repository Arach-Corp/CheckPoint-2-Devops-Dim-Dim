package br.com.dimdim.dimdim.repositories;

import br.com.dimdim.dimdim.entities.Movimentacao;
import br.com.dimdim.dimdim.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    Page<Movimentacao> findAllByUsuario(Usuario usuario);
}
