package org.brocom.spring.boot.web;

import org.brocom.spring.boot.properties.MyBean;
import org.brocom.spring.boot.properties.MyServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private ApplicationArguments arguments;

    @Autowired
    private MyBean myBean;

    @Autowired
    private MyServerProperties myServerProperties;

    @RequestMapping("/")
    public String index() {
        return "author:{name:Nazar,family:Myza}\n" +
                "property 'name': " + myBean.getName() +
                "\n ==|||||== \n" +
                arguments.getOptionNames().toString() +
                "\n ==|||||== \n" +
                myServerProperties.getEmail();
    }
}
