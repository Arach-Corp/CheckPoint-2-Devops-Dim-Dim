package br.com.dimdim.dimdim.controller.dro;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentacaoForm {
    private String descricao;
    private BigDecimal valor;
}
