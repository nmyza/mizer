package org.brocom.spring.boot.web;

import org.brocom.spring.boot.properties.IBean;
import org.brocom.spring.boot.properties.MyBean;
import org.brocom.spring.boot.properties.MyServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/api/users/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable String user) {
        return "--" + user + "--";
    }

    @RequestMapping(value = "/converter", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public IBean converter() {
        return myBean;
    }

    @RequestMapping(value = "/response", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> response() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(myBean);
    }
}
