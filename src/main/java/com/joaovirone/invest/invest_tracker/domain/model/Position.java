package com.joaovirone.invest.invest_tracker.domain.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder // padrão builder para criar projetos complexos de forma limpa
@ToString
public class Position {
    
    private Asset asset;                // O ativo original
    private BigDecimal currentPrice;    // Preço atual (vindo da API)
    private BigDecimal totalValue;      // Quanto vale hoje (Qtd * Preço Atual)
    private BigDecimal profitOrLoss;    // Lucro/Prejuízo em valor (R$)
    private BigDecimal roi;             // Retorno sobre Investimento (%)


    // método auxiliar para facilitar a visualização no log/console
    public String getFormattedRoi(){
        return roi + "%";
    }
}
