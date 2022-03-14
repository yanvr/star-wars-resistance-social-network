package com.letscode.starwarsresistancenetwork.models;

import com.letscode.starwarsresistancenetwork.Enums.RebelGender;
import com.letscode.starwarsresistancenetwork.Enums.RebelStatus;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_rebels")
public class Rebel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rebel_id")
    private Long id;
    private String name;
    private int age;
    private RebelGender gender;
    @OneToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(mappedBy = "rebel")
    private List<Item> inventory;
    private RebelStatus status;

    public static Rebel of(RebelRequest request) {
        Rebel rebel = new Rebel();
        BeanUtils.copyProperties(request, rebel);
        rebel.setStatus(RebelStatus.REBEL);
        return rebel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rebel rebel = (Rebel) o;
        return id != null && Objects.equals(id, rebel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
