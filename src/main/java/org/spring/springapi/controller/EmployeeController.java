package org.spring.springapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome to the Employee API";
    }

}
