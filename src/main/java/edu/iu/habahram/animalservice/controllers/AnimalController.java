package edu.iu.habahram.animalservice.controllers;

import edu.iu.habahram.animalservice.model.AnimalData;
import edu.iu.habahram.animalservice.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<AnimalData> findAll(){
        try {
            return animalRepository.findAll();
        } catch (IOException e) {
            return null;
        }
    }

    @PostMapping
    public boolean add(@RequestBody AnimalData data) {
        try {
            return animalRepository.add(data);
        } catch (IOException e) {
            return false;
        }
    }
}
