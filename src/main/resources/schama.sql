DROP TABLE IF EXISTS bank_response;

CREATE TABLE bank_response (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    bankName VARCHAR(250) NOT NULL,
    borrowerName VARCHAR(250) NOT NULL,
        principal VARCHAR(250) ,
            interestAmount VARCHAR(250) ,
                totalAmount VARCHAR(250) ,
                    remainingAmount VARCHAR(250) ,
                        noOfYears VARCHAR(250) NOT ,
                            totalEmi VARCHAR(250) ,
                              rateOfInterest VARCHAR(250) ,
                              emiValue VARCHAR(250) ,

);
