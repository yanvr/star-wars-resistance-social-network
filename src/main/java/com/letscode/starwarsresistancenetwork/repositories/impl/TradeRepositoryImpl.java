package com.letscode.starwarsresistancenetwork.repositories.impl;

import com.letscode.starwarsresistancenetwork.models.Trade;
import com.letscode.starwarsresistancenetwork.repositories.TradeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TradeRepositoryImpl {

    private TradeRepository repository;

    public Trade save(Trade trade) {
        return repository.save(trade);
    }
}
