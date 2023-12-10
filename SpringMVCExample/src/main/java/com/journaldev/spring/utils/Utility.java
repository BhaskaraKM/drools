package com.journaldev.spring.utils;

import org.drools.core.rule.consequence.KnowledgeHelper;

public class Utility {

    public static void help(final KnowledgeHelper drools, final String message){
        System.out.println(message);
        System.out.println("\nrule triggered: " + drools.getRule().getName());
    }
    public static void helper(final KnowledgeHelper drools){
        System.out.println("\nrule triggered: " + drools.getRule().getName());
    }
}
