package app.services;

import app.helpers.DataLoader;
import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SpaceShipService {

    private DataLoader dataLoader;

    private SpaceShipRepo spaceShipRepo;


    @Autowired

    public SpaceShipService(DataLoader dataLoader, SpaceShipRepo spaceShipRepo) {
        this.dataLoader = dataLoader;
        this.spaceShipRepo = spaceShipRepo;

    }

    private Map<Long, SpaceShip> spaceShip = new TreeMap<>();

    public List<SpaceShip> getAll() {
        return new ArrayList<>(spaceShip.values());
    }

}
