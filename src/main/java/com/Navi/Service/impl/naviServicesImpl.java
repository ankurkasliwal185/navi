package com.Navi.Service.impl;

import com.Navi.Constant.Constants;
import com.Navi.Repository.BankRepository;
import com.Navi.dto.BalanceData;
import com.Navi.dto.LoneData;
import com.Navi.dto.PaymentData;
import com.Navi.dto.BankData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class naviServicesImpl {

    @Autowired
    BankRepository bankRepository ;

    public boolean processFile(String fileName) {
        readFileFromCSV(fileName);
        return true;
    }
    public  void processLoneData(List<LoneData> loneData){
        for(LoneData data:loneData) {
            BankData bankData = new BankData();
            bankData.setBankName(data.getBankName());
            bankData.setBorrowerName(data.getBorrowerName());
            bankData.setPrincipal(data.getPrincipal());
            bankData.setNoOfYears(data.getNoOfYears());
            bankData.setRateOfInterest(data.getRateOfInterest());
            bankData.setInterestAmount(data.getPrincipal()*data.getNoOfYears()*data.getRateOfInterest()/100);
            bankData.setTotalAmount(bankData.getInterestAmount()+ bankData.getPrincipal());
            bankData.setRemainingAmount(bankData.getInterestAmount()+ bankData.getPrincipal());
            bankData.setTotalEmi(data.getNoOfYears()*12);
            bankData.setRemainingEmi(bankData.getTotalEmi());
            bankData.setLumpSumAmount(0);
            bankData.setLumSumEmi(0);
            Long emivalue = bankData.getRemainingAmount()/bankData.getTotalEmi() ;
            if(bankData.getRemainingAmount()%bankData.getTotalEmi()!=0){
                emivalue = emivalue+1;
            }
            bankData.setEmiValue(emivalue.intValue());
            bankRepository.save(bankData);
        }
    }
    public  void processPaymentData(List<PaymentData> paymentData){
        for(PaymentData data: paymentData){
            BankData bankData = bankRepository.findByBankNameAndBorrowerName(data.getBankName(), data.getBorrowerName()).get();
            bankData.setLumpSumAmount(data.getLumpSumAmount());
            bankData.setLumSumEmi(data.getEmiNo());
            bankRepository.save(bankData);
        }
    }
    public  void processBalanceData(List<BalanceData> balanceData){
        for(BalanceData data:balanceData){
            BankData bankData = bankRepository.findByBankNameAndBorrowerName(data.getBankName(), data.getBorrowerName()).get();
            if(data.getEmiNo()< bankData.getLumSumEmi()){
                int AMOUNT_PAID = bankData.getEmiValue()*data.getEmiNo();
                int NO_OF_EMIS_LEFT = bankData.getTotalEmi()-data.getEmiNo();
                System.out.println(bankData.getBankName() + " " + bankData.getBorrowerName() + " " +AMOUNT_PAID +" "+ NO_OF_EMIS_LEFT  );
            }else{
                int x1 = bankData.getEmiValue()*data.getEmiNo();
                Long AMOUNT_PAID = x1+ bankData.getLumpSumAmount();
                Long LumSumEMICovered= bankData.getLumpSumAmount()/ bankData.getEmiValue();
                int NO_OF_EMIS_LEFT = (int) (bankData.getTotalEmi()-data.getEmiNo()-LumSumEMICovered);
                System.out.println(bankData.getBankName() + " " + bankData.getBorrowerName() + " " +AMOUNT_PAID +" "+ NO_OF_EMIS_LEFT  );

            }

        }
    }

    public  void readFileFromCSV (String fileName){
        Path pathToFile = Paths.get(fileName);
        List<LoneData> loneData = new ArrayList<>();
        List<BalanceData> balanceData=new ArrayList<>();
        List<PaymentData> paymentData = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(pathToFile)){
            String line = br.readLine();
            while (line != null) {
                String [] variable = line.split(" ");
                if(variable[0].equals(Constants.FieldType.LOAN.name())){
                    LoneData Data = new LoneData(variable[0],variable[1],variable[2],Long.parseLong(variable[3]),Integer.parseInt(variable[4]),Integer.parseInt(variable[5]));
                    loneData.add(Data);
                }else if(variable[0].equals(Constants.FieldType.PAYMENT.name())){
                    PaymentData Data = new PaymentData(variable[0],variable[1],variable[2],Long.parseLong(variable[3]),Integer.parseInt(variable[4]));
                    paymentData.add(Data);
                }else if(variable[0].equals(Constants.FieldType.BALANCE.name())){
                    BalanceData Data = new BalanceData(variable[0],variable[1],variable[2],Integer.parseInt(variable[3]));
                    balanceData.add(Data);
                }
               line = br.readLine();
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }

        processLoneData(loneData);
        processPaymentData(paymentData);
        processBalanceData(balanceData);

    }

}
