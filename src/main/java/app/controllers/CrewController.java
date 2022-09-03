package app.controllers;


import app.models.Crew;
import app.models.SpaceShip;
import app.repositories.CrewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CrewController {

    @Autowired
    private CrewRepo crewRepo;

    @GetMapping(value = {"/crewlist"})
    String allCrew (Model model) {

        List<Crew> crew = (List<Crew>) crewRepo.findAll();
        model.addAttribute("crewlist", crew);
        return "crewlist";
    }

}
