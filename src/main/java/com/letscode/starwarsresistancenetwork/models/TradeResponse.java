package com.letscode.starwarsresistancenetwork.models;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class TradeResponse {

    private Long id;
    private Long rebel1Id;
    private Long rebel2Id;
    private List<Item> tradeListRebel1;
    private List<Item> tradeListRebel2;

    public static TradeResponse of(Trade trade) {
        TradeResponse response = new TradeResponse();
        BeanUtils.copyProperties(trade, response);
        return response;
    }
}
