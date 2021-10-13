package com.Navi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity(name = "BANK_RESPONSE")
@Table(name ="BANK_RESPONSE")
public class BankData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private  Long id;
    @JsonProperty("bankName")
    @Column(name = "bankName")
    private String bankName;
    @JsonProperty("borrowerName")
    @Column(name = "borrowerName")
    private String borrowerName;
    @JsonProperty("principal")
    @Column(name = "principal")
    private long principal;
    @JsonProperty("interestAmount")
    @Column(name = "interestAmount")
    private long interestAmount;
    @JsonProperty("totalAmount")
    @Column(name = "totalAmount")
    private long totalAmount;
    @JsonProperty("remainingAmount")
    @Column(name = "remainingAmount")
    private long remainingAmount;
    @JsonProperty("noOfYears")
    @Column(name = "noOfYears")
    private int noOfYears;
    @JsonProperty("totalEmi")
    @Column(name = "totalEmi")
    private int totalEmi;
    @JsonProperty("remainingEmi")
    @Column(name = "remainingEmi")
    private int remainingEmi;
    @JsonProperty("rateOfInterest")
    @Column(name = "rateOfInterest")
    private int rateOfInterest;
    @JsonProperty("emiValue")
    @Column(name = "emiValue")
    private int emiValue;
    @JsonProperty("LumpSumAmount")
    @Column(name = "LumpSumAmount")
    private long LumpSumAmount;
    @JsonProperty("LumSumEmi")
    @Column(name = "LumSumEmi")
    private int LumSumEmi;

}
