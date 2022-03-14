package com.letscode.starwarsresistancenetwork.models;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ReportResponse {

    private String informantId;
    private String traitorId;

    public static ReportResponse of(Report report) {
        ReportResponse reponse = new ReportResponse();
        BeanUtils.copyProperties(report, reponse);
        return reponse;
    }
}
