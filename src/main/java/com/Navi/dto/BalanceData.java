package com.Navi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BalanceData {

    @JsonProperty("field")
    private String field;
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("borrowerName")
    private String borrowerName;
    @JsonProperty("emiNo")
    private int emiNo;

    public BalanceData(String field, String bankName, String borrowerName, int emiNo) {
        this.field = field;
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNo = emiNo;
    }
}
