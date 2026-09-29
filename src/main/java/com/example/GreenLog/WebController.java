package com.example.GreenLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    @GetMapping("/plantation")
    public String plantation() {
        return "plantation";
    }
    @GetMapping("/volunteers")
    public String volunteers() {
        return "volunteers";
    }

    @GetMapping("/drives")
    public String drives() {
        return "drives";
    }

    @GetMapping("/survival-checks")
    public String survivalChecks() {
        return "survival-checks";
    }
}