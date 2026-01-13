package com.joaovirone.invest.invest_tracker.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Asset {
    
    private String ticker; //ex PETR4, BTC e etc...
    private BigDecimal quantity; //quantidade que eu tenho
    private BigDecimal averagePrice; //preço médio de compra

    //Regra de negócio = calcular valor total investido

    public BigDecimal getTotalCost() {
        
        return this.quantity.multiply(this.averagePrice);
    }

}
