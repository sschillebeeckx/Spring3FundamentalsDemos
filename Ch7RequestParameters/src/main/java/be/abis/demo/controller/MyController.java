package be.abis.demo.controller;

import be.abis.demo.model.Company;
import be.abis.demo.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ReceptionService receptionService;

    @GetMapping("/persons/{id}")
    public String home(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "Hello " + receptionService.getHelloService().findPerson(id).getFirstName());
        return "home";
    }

    @GetMapping("companies")
    public String showComps(@RequestParam("country") String country, Model model){
        List<Company> countryCompanies=
                receptionService.getCompaniesForCountry(country);
        model.addAttribute("comps",countryCompanies);
        return "companylist";
    }

}
