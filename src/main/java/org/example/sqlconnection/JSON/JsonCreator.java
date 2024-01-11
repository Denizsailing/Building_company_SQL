package org.example.sqlconnection.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonCreator {
    public static void main(String[] args) {

        Project project = new Project();
        project.setProjectId(1);
        project.setProjectName("Project 3");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(project);


            String fileName = "project_data.json";
            File file = new File(fileName);
            objectMapper.writeValue(file, project);

            System.out.println("JSON file created successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
