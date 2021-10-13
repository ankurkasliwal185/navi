package com.Navi.Repository;


import com.Navi.dto.BankData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankData, Long> {

    @Override
    Optional<BankData> findById(Long aLong);

//    @Query("select inv from BankData inv "
//            + "where inv.bankName in (:bankName) " +
//            "inv.borrowerName = :borrowerName ")
    Optional<BankData> findByBankNameAndBorrowerName(String bankName,String borrowerName);
}
