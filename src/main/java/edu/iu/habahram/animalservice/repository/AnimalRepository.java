package edu.iu.habahram.animalservice.repository;

import edu.iu.habahram.animalservice.model.AnimalData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalRepository {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "db.txt";
    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }


    public boolean add(AnimalData animalData) throws IOException {
         Path path = Paths.get(DATABASE_NAME);
         String data = animalData.getPicture() + "," + animalData.getLocation();
         appendToFile(path, data + NEW_LINE);
         return true;
    }

    public List<AnimalData> findAll() throws IOException {
        List<AnimalData> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            String[] words = line.split(",");
            AnimalData a = new AnimalData();
            a.setPicture(words[0]);
            a.setLocation(words[1] + "," + words[1]);
            result.add(a);
        }
        return result;
    }
}
