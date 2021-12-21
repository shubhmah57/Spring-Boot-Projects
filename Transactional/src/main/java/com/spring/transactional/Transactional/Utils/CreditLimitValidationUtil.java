package com.spring.transactional.Transactional.Utils;

import com.spring.transactional.Transactional.Exception.BalanceInSufficientException;

import java.util.HashMap;
import java.util.Map;

public class CreditLimitValidationUtil {

    private static  Map<String, Double> accountsMap = new HashMap<>();

    static {
        accountsMap.put("account1", 12000.0);
        accountsMap.put("account2", 10000.0);
        accountsMap.put("account3", 18000.0);
        accountsMap.put("account4", 38000.0);
    }

    public static boolean validateLimit(String accountNumber, double amount){

        if(null!= accountNumber && accountsMap.get(accountNumber) > amount){
            return true;
        }
        else {
            throw new BalanceInSufficientException("Insufficient Balance For The Transaction!");
        }
    }
}
