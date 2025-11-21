package be.abis.demo.controller;

import be.abis.demo.model.Company;
import be.abis.demo.repository.CompanyRepository;
import be.abis.demo.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/companyForm")
    public String showForm(Model model){
        Company c = new Company();
        c.setCompanyNumber
                (receptionService.getCompanyRepository().getKeyValue());
        model.addAttribute("company", c);
        return "companyForm";
    }
    @PostMapping("/companyForm")
    public String addForm(Model model,
                          @ModelAttribute("company") Company company,
                          RedirectAttributes attrs){
        CompanyRepository comprepo = receptionService.getCompanyRepository();
        System.out.println(company);
        comprepo.insertCompany(company);
        attrs.addFlashAttribute("addedcomp", company);
        return "redirect:/showCompData";
    }

    @GetMapping("/showCompData")
    public String showData(Model model,
                           @ModelAttribute("addedcomp") Company company){
        System.out.println(company);
        model.addAttribute("addedcomp", company);
        return "showCompData";
    }

}
