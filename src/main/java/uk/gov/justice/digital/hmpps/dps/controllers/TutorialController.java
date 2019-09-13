package uk.gov.justice.digital.hmpps.dps.controllers;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TutorialController {

    @GetMapping("/tutorials/hdc")
    public String hdc() {
        return "hdc";
    }


}
