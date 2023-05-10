package ru.osipov.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @GetMapping("/calc")
    public String calc(@RequestParam(required = false) double a,
                       @RequestParam(required = false) double b,
                       @RequestParam(required = false) String action,
                       Model model) {
        String result = switch (action) {
            case "multiplication" -> "Result of multiplication " + a + " and " + b + " is " + (a * b);
            case "addition" -> "Result of addition " + a + " and " + b + " is " + (a + b);
            case "subtraction" -> "Result of subtraction " + a + " and " + b + " is " + (a - b);
            case "division" -> "Result of division " + a + " and " + b + " is " + (a / b);
            default -> "Failed action";
        };

        model.addAttribute("result", result);
        return "calc/calc";
    }
}