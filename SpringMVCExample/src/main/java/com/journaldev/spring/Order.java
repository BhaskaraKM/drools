package com.journaldev.spring;

import lombok.Data;

@Data
public class Order {

    private String name;
    private String cardType;
    private int discount;
    private Integer price;
}