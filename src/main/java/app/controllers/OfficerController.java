package app.controllers;

import app.repositories.OfficerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficerController {

    private final OfficerRepo officerRepo;

    public OfficerController(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}
