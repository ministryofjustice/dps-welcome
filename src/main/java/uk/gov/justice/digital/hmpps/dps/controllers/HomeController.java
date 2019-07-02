package uk.gov.justice.digital.hmpps.dps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }


}
