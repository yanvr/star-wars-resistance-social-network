package com.letscode.starwarsresistancenetwork.repositories.impl;

import com.letscode.starwarsresistancenetwork.models.Report;
import com.letscode.starwarsresistancenetwork.repositories.ReportRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReportRepositoryImpl {

    private final ReportRepository repository;

    public boolean contains(Report report) {
        return repository.exists(report);
    }

    public Report save(Report report) {
        repository.save(report);
        return report;
    }

    public List<Report> findAllById(Long id) {
        return repository.findAllById(id);
    }

    public int countById(Long id) {
        return repository.countById(id);
    }
}
