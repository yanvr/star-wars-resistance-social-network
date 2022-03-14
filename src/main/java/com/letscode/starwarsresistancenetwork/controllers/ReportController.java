package com.letscode.starwarsresistancenetwork.controllers;

import com.letscode.starwarsresistancenetwork.models.ReportRequest;
import com.letscode.starwarsresistancenetwork.models.ReportResponse;
import com.letscode.starwarsresistancenetwork.services.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ReportResponse save(@RequestBody ReportRequest request) {
        log.info("Reporting traitor: {}", request.getTraitorId());
        ReportResponse reportResponse = service.save(request);
        log.info("Traitor reported: {}", reportResponse);
        return reportResponse;
    }
}
