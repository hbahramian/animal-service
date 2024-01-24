package edu.iu.habahram.animalservice.repository;

import edu.iu.habahram.animalservice.model.AnimalData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryTest {

    @BeforeAll
    static void setup() throws IOException {
        Files.deleteIfExists(Paths.get("db.txt"));
    }

    @AfterAll
    static void cleanup() throws IOException {
        Files.delete(Paths.get("db.txt"));
    }

    @Test
    void addLion() {
        AnimalData x = new AnimalData();
        x.setPicture("lion1.jpg");
        x.setLocation("24,56");

        AnimalRepository animalRepository = new AnimalRepository();
        boolean result = false;
        try {
            result = animalRepository.add(x);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
        assertTrue(result);
    }

    @Test
    void addWolf() {
        AnimalData x = new AnimalData();
        x.setPicture("wolf1.jpg");
        x.setLocation("13,45");

        AnimalRepository animalRepository = new AnimalRepository();
        boolean result = false;
        try {
            result = animalRepository.add(x);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
        assertTrue(result);
    }


    @Test
    void findAll() {
       AnimalRepository animalRepository = new AnimalRepository();
        try {
            List<AnimalData> data = animalRepository.findAll();
            assertEquals(2, data.size());
        } catch (IOException e) {
            fail();
        }
    }
}