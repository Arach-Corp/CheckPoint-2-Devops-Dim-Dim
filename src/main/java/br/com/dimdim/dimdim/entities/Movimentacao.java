package br.com.dimdim.dimdim.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
    private Long id;

    @Column(name = "ds_movimentacao", length = 80)
    private String descricao;

    @Column(name = "vl_movimentacao", scale = 4, precision = 20)
    private BigDecimal valor;

    @CreationTimestamp
    @Column(name = "dt_movimentacao")
    private LocalDateTime dataMovimentacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Movimentacao(Long id, String descricao, BigDecimal valor, LocalDateTime dataMovimentacao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataMovimentacao = dataMovimentacao;
        this.usuario = usuario;
    }
}
