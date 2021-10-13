package com.Navi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoneData {

    @JsonProperty("field")
    private String field;
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("borrowerName")
    private String borrowerName;
    @JsonProperty("principal")
    private Long principal;
    @JsonProperty("noOfYears")
    private int noOfYears;
    @JsonProperty("rateOfInterest")
    private int rateOfInterest;

    public LoneData(String field, String bankName, String borrowerName, Long principal, int noOfYears,int rateOfInterest) {
        this.field = field;
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest= rateOfInterest;
    }
}
