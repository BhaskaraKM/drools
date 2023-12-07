package com.journaldev.spring;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private KieContainer kieContainer;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Order processRules(@RequestBody Order order) {
        KieSession kieSession = kieContainer.newKieSession();
        KieRuntime kieRuntime = (KieRuntime) kieSession;
        kieRuntime.setGlobal("showResults", new OutputDisplay());
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }
}
