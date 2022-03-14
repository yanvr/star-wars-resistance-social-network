package com.letscode.starwarsresistancenetwork.services;

import com.letscode.starwarsresistancenetwork.Enums.RebelStatus;
import com.letscode.starwarsresistancenetwork.exceptions.BusinessException;
import com.letscode.starwarsresistancenetwork.models.Item;
import com.letscode.starwarsresistancenetwork.models.Rebel;
import com.letscode.starwarsresistancenetwork.models.Trade;
import com.letscode.starwarsresistancenetwork.models.TradeResponse;
import com.letscode.starwarsresistancenetwork.repositories.impl.TradeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TradeService {

    private final RebelService rebelService;
    private final InventoryService inventoryService;
    private final TradeRepositoryImpl tradeRepositoryImpl;

    public TradeResponse trade(Trade trade) {
        Rebel rebel1 = rebelService.findById(trade.getRebel1Id());
        Rebel rebel2 = rebelService.findById(trade.getRebel1Id());

        int qtdPointsRebel1 = calculateTradePoints(trade.getTradeListRebel1());
        int qtdPointsRebel2 = calculateTradePoints(trade.getTradeListRebel2());

        if ((rebel1.getStatus().equals(RebelStatus.TRAITOR) || rebel2.getStatus().equals(RebelStatus.TRAITOR))
                || qtdPointsRebel1 != qtdPointsRebel2) {
            throw new BusinessException("The quantity of points for trade are different");
        }
        inventoryService.update(rebel1.getId(), trade.getTradeListRebel2(), trade.getTradeListRebel1());
        inventoryService.update(rebel2.getId(), trade.getTradeListRebel1(), trade.getTradeListRebel2());

        return TradeResponse.of(save(trade));
    }

    public Trade save(Trade trade) {
        return tradeRepositoryImpl.save(trade);
    }

    private int calculateTradePoints(List<Item> tradeItems) {
        return tradeItems.stream().mapToInt(item -> item.getPoints() * item.getQuantity()).sum();
    }
}
