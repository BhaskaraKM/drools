package com.journaldev.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


public class Account {

    private String accountId;
    private String accountType;
    private String statuCode;



    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(String statuCode) {
        this.statuCode = statuCode;
    }
}
