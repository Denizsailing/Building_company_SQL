package org.example.sqlconnection.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


import java.util.List;
public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Project project = objectMapper.readValue(new File("C:\\Users\\deniz\\UniqueWordsCounter\\Building_company_SQL\\src\\main\\resources\\building_company\\building_company\\jsonfile\\Project.json"), Project.class);
            // Now you can work with the parsed project object

            // Print project details
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Start Date: " + project.getStartDate());
            System.out.println("End Date: " + project.getEndDate());

            Department department = project.getDepartment();
            System.out.println("Department Name: " + department.getDepartmentName());

            List<Customer> customers = department.getCustomers();
            for (Customer customer : customers) {
                System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());

                Address address = customer.getAddress();
                System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getPostalCode());

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}