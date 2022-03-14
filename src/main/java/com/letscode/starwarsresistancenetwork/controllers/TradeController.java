package com.letscode.starwarsresistancenetwork.controllers;

import com.letscode.starwarsresistancenetwork.models.Trade;
import com.letscode.starwarsresistancenetwork.models.TradeRequest;
import com.letscode.starwarsresistancenetwork.models.TradeResponse;
import com.letscode.starwarsresistancenetwork.services.TradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/trades")
@Slf4j
@RequiredArgsConstructor
public class TradeController {

    private final TradeService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public TradeResponse trade(@RequestBody TradeRequest request) {
      log.info("Making a trade: {}", request);
      Trade trade = Trade.of(request);
      log.info("Trade fulfilled with success.");
      return service.trade(trade);
    }
}
