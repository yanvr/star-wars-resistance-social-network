package com.letscode.starwarsresistancenetwork.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tb_trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id", nullable = false)
    private Long id;
    private Long rebel1Id;
    private Long rebel2Id;
    @ManyToMany
    private List<Item> tradeListRebel1;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trade_items",
    joinColumns = {@JoinColumn(name = "item_id")},
    inverseJoinColumns = {@JoinColumn(name = "trade_id")})
    private List<Item> tradeListRebel2;

    public static Trade of(TradeRequest request) {
        Trade newTrade = new Trade();
        BeanUtils.copyProperties(request, newTrade);
        return newTrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trade trade = (Trade) o;
        return id != null && Objects.equals(id, trade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
