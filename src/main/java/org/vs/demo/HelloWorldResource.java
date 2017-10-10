package org.vs.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
