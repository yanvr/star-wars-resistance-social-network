package com.letscode.starwarsresistancenetwork.repositories;

import com.letscode.starwarsresistancenetwork.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllById(Long id);

    int countById (Long id);

    boolean exists(Object object);
}
