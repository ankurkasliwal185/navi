package com.Navi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentData {

    @JsonProperty("field")
    private String field;
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("borrowerName")
    private String borrowerName;
    @JsonProperty("lumpSumAmount")
    private Long lumpSumAmount;
    @JsonProperty("emiNo")
    private int emiNo;

    public PaymentData(String field, String bankName, String borrowerName, Long lumpSumAmount, int emiNo) {
        this.field = field;
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }
}
