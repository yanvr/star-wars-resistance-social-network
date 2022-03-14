package com.letscode.starwarsresistancenetwork.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long informantId;
    private Long traitorId;

    public static Report of(ReportRequest request) {
        Report report = new Report();
        BeanUtils.copyProperties(request, report);
        return report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Report report = (Report) o;
        return id != null && Objects.equals(id, report.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
