package app.controllers;

import app.models.Officer;
import app.repositories.OfficerRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfficerController {

    private final OfficerRepo officerRepo;

    public OfficerController(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }
   /* @GetMapping("/login")
    public String loginPage() {
        return "login";
    }*/
   @GetMapping("/registration")
   public String RegistrationForm(Model model) {
       model.addAttribute("user", new Officer());
       return "registration";

       /*@PostMapping("/registration")
    public String officerReg (Officer user) {
           BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
           String encodedPassword = encoder.encode(Officer.getPassword());
           officerRepo.save(user);
        return "redirect:/login";*/
    }

    }


