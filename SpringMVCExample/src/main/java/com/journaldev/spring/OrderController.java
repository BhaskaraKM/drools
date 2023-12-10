package com.journaldev.spring;

import com.journaldev.spring.model.Account;
import com.journaldev.spring.model.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class OrderController {

    @Autowired
    private KieContainer kieContainer;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Order processRules(@RequestBody Order order) {
        Map<String, Message> mapResult = new HashMap<String, Message>();
        KieSession kieSession = kieContainer.newKieSession();
        KieRuntime kieRuntime = (KieRuntime) kieSession;
        kieRuntime.setGlobal("mapResult", mapResult);
        kieRuntime.insert(order);
        kieSession.fireAllRules();

        System.out.println("map size - "+mapResult.size());
        return order;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Message> processAccountRules(@RequestBody List<Account> accounts) {
        Map<String, Message> mapResult = new HashMap<String, Message>();
        KieSession kieSession = kieContainer.newKieSession();
        KieRuntime kieRuntime = (KieRuntime) kieSession;
        kieRuntime.setGlobal("mapResult", mapResult);
        kieSession.insert(accounts);
        kieSession.fireAllRules();

        return mapResult;
    }


   /* private Account getAccount(){
        Account account1  = new Account("12345", "CDA", "IN_GRACE");
        return  account1;
    }

    private List<Account> getAccounts(){

        Account account1  = new Account("12345", "CDA", "IN_GRACE");
        Account account2 = new Account("12346", "CDA", "IN_GRACE");
        Account account3 = new Account("12347", "CDA", "RENEWAL_TODAY");
        List<Account> accountList = Arrays.asList(account1, account2,  account3);

        return  accountList;

    }*/
}
