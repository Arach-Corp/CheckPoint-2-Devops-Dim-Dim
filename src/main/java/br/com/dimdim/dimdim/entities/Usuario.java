package br.com.dimdim.dimdim.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_usuario")
    private String nome;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_password")
    private String password;

    @Column(name = "vl_saldo", precision = 20, scale = 2)
    private BigDecimal saldo;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "usuario")
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Usuario(Long id, String nome, String email, String password, BigDecimal saldo, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.saldo = saldo;
        this.dataCadastro = dataCadastro;
    }

    public void addMovimentacao(Movimentacao movimentacao)  {
        if (Objects.nonNull(movimentacao)){
            getMovimentacoes().add(movimentacao);
            movimentacao.setUsuario(this);
            if (Objects.isNull(getSaldo())){
                this.saldo = BigDecimal.ZERO;
            }
            setSaldo(getSaldo().add(movimentacao.getValor()));
        }
    }
}
