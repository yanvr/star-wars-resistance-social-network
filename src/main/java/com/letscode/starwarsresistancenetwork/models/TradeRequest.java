package com.letscode.starwarsresistancenetwork.models;

import lombok.Data;

import java.util.List;

@Data
public class TradeRequest {

    private Long rebel1Id;
    private Long rebel2Id;
    private List<Item> tradeListRebel1;
    private List<Item> tradeListRebel2;
}
