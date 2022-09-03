package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class SpaceShipController {
    @Autowired
    private SpaceShipRepo spaceShipRepo;


    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }


    @GetMapping(value={"/spaceshiplist"})
        String spaceShipDatas(Model model){

        List<SpaceShip> spaceShipList = (List<SpaceShip>) spaceShipRepo.findAll();
        model.addAttribute("spaceshiplist", spaceShipList);
        return "spaceshiplist";
    }


}
