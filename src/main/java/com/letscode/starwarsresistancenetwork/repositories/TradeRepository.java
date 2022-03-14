package com.letscode.starwarsresistancenetwork.repositories;

import com.letscode.starwarsresistancenetwork.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
