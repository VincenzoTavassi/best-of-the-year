package com.excercises.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "Vincenzo Tavassi");
        return "index";
    }
}