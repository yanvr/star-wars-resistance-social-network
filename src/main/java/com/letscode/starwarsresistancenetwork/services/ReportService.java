package com.letscode.starwarsresistancenetwork.services;

import com.letscode.starwarsresistancenetwork.exceptions.BusinessException;
import com.letscode.starwarsresistancenetwork.models.Report;
import com.letscode.starwarsresistancenetwork.models.ReportRequest;
import com.letscode.starwarsresistancenetwork.models.ReportResponse;
import com.letscode.starwarsresistancenetwork.repositories.impl.ReportRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final ReportRepositoryImpl reportRepositoryImpl;
    private final RebelService rebelService;

    public boolean contains(Report report) {
        return reportRepositoryImpl.contains(report);
    }

    public ReportResponse save(ReportRequest request) {
        Report newReport = Report.of(request);

        if (contains(newReport)) {
            throw new BusinessException("The report already informed");
        }
        Report savedReport = reportRepositoryImpl.save(newReport);

        int quantityReports = reportRepositoryImpl.countById(request.getTraitorId());

        log.info("quantidade de reports: {}", quantityReports);

        if (quantityReports >= 3) rebelService.updateStatus(request.getTraitorId());


        return ReportResponse.of(savedReport);
    }

    public List<Report> findAllById(Long id) {
        return reportRepositoryImpl.findAllById(id);
    }

    public int count(Long id) {
        return reportRepositoryImpl.countById(id);
    }

}
