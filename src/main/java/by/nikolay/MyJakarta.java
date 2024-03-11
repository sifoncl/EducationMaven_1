package by.nikolay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyJakarta {

    private String version;
    private String description;
    private Set<Technology> technologies = new LinkedHashSet<>();


    public void writeToJson(String path) throws IOException {

        File file = new File(path);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, this);

    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }

    static MyJakarta readFromJson(String path) throws IOException {

        Path p = Path.of(path);
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] jsonData = Files.readAllBytes(p);

        MyJakarta mJ = objectMapper.readValue(jsonData, MyJakarta.class);

        return mJ;
    }

    static void updateTechnology(Technology technology, String paths) throws IOException {
        MyJakarta mJ = MyJakarta.readFromJson(paths);
        mJ.technologies.add(technology);
        mJ.writeToJson(paths);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTechnology(Technology... args) {
        for (Technology t : args) {
            this.technologies.add(t);
        }
    }

    @Override
    public String toString() {
        return "MyJakarta{" +
                "version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", technologies=" + technologies +
                '}';
    }
}
