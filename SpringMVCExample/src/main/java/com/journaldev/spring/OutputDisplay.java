package com.journaldev.spring;


import java.util.Date;

/**
 * Class for testing global variable in Drools engine.
 */
public class OutputDisplay {

    public void showText(String text) {
        System.out.println("==================================================");
        System.out.println("Text: " + text + ",  date: " + new Date().toString());
        System.out.println("==================================================");
    }

}
