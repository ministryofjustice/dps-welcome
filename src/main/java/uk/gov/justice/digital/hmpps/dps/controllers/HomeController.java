package uk.gov.justice.digital.hmpps.dps.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final String pNomisUrl;
    private final String dpsHomeUrl;

    public HomeController(@Value("${app.services.pnomis-url}") String pNomisUrl, @Value("${app.services.dps-home-url}") String dpsHomeUrl) {
        this.pNomisUrl = pNomisUrl;
        this.dpsHomeUrl = dpsHomeUrl;
    }

    @GetMapping("/")
    public ModelAndView home() {

        List<Service> services = List.of(
                Service.builder().name("P-NOMIS").description("Classic P-NOMIS").healthOk(true).url(pNomisUrl).build(),
                Service.builder().name("DPS").description("DPS - New Nomis").healthOk(true).url(dpsHomeUrl).build()
        );

        return new ModelAndView("home","services", services);
    }

    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }


}
