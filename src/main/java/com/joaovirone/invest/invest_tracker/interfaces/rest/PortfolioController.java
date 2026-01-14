package com.joaovirone.invest.invest_tracker.interfaces.rest;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaovirone.invest.invest_tracker.domain.model.Asset;
import com.joaovirone.invest.invest_tracker.domain.model.Position;
import com.joaovirone.invest.invest_tracker.domain.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;


    // Exemplo de chamada: GET /api/portfolio/PETR4?amount=100&price=30.00

    @GetMapping("/{ticker}")
    public ResponseEntity<Position> getPosition(

        @PathVariable String ticker,
        @RequestParam BigDecimal amount, //Quantidade de ações
        @RequestParam BigDecimal price
    ){

        // Monta o ativo com os dados que chegaram da requisição
        Asset asset = new Asset(ticker, amount, price);

        // Chama o serviço (code do DDD) para fazer a mágica
        Position position = portfolioService.calculatePosition(asset);

        // Retorna o JSON completo
        return ResponseEntity.ok(position);
    }
}
