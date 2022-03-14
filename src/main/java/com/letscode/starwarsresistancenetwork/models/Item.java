package com.letscode.starwarsresistancenetwork.models;

import com.letscode.starwarsresistancenetwork.Enums.ItemDefinitions;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    ItemDefinitions definitions;
    private int points = definitions.getItemPoints();
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "rebel_id", nullable = false)
    private Rebel rebel;
    @ManyToOne
    private Trade trade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
