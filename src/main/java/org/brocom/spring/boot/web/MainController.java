package org.brocom.spring.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "author:{name:Nazar,family:Myza}";
    }
}
