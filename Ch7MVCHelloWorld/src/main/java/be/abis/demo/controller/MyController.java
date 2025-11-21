package be.abis.demo.controller;

import be.abis.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @Autowired
    private HelloService helloService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello " + helloService.findPerson(1).getFirstName());
        return "home";
    }
}
