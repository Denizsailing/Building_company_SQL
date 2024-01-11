package org.example.sqlconnection;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParser {
    public static void main(String[] args) {
        String xmlFilePath = "C:\\Users\\deniz\\UniqueWordsCounter\\Building_company_SQL\\src\\main\\resources\\building_company\\building_company\\employees.xml";

        // Parse XML file with SAX Parser
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            NodeList employeeList = document.getElementsByTagName("employee");
            if (employeeList.getLength() > 0) {
                for (int i = 0; i < employeeList.getLength(); i++) {
                    Element employeeElement = (Element) employeeList.item(i);

                    int employeeId = Integer.parseInt(getElementTextContent(employeeElement, "employeeId"));
                    String firstName = getElementTextContent(employeeElement, "firstName");
                    String lastName = getElementTextContent(employeeElement, "lastName");
                    String email = getElementTextContent(employeeElement, "email");
                    String phone = getElementTextContent(employeeElement, "phone");
                    String hireDate = getElementTextContent(employeeElement, "hireDate");
                    BigDecimal salary = new BigDecimal(getElementTextContent(employeeElement, "salary"));
                    String jobTitle = getElementTextContent(employeeElement, "jobTitle");
                    int departmentId = Integer.parseInt(getElementTextContent(employeeElement, "departmentId"));
                    int managerId = Integer.parseInt(getElementTextContent(employeeElement, "managerId"));

                    // Create an Employee object and populate the data
                    Employee employee = new Employee();
                    employee.setEmployeeId(employeeId);
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setEmail(email);
                    employee.setPhone(phone);
                    // Diğer özellikleri ayarla

                    System.out.println("Employee data:");
                    System.out.println("Employee ID: " + employee.getEmployeeId());
                    System.out.println("First Name: " + employee.getFirstName());
                    System.out.println("Last Name: " + employee.getLastName());
                    System.out.println("Email: " + employee.getEmail());
                    System.out.println("Phone: " + employee.getPhone());
                    // Diğer özellikleri yazdır
                }
            } else {
                System.out.println("No employee data found in the XML file.");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // Parse XML file with JAXB
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File(xmlFilePath));
            List<Employee> employeeList = employees.getEmployeeList();

            if (employeeList != null && !employeeList.isEmpty()) {
                for (Employee employee : employeeList) {
                    System.out.println("Employee data:");
                    System.out.println("Employee ID: " + employee.getEmployeeId());
                    System.out.println("First Name: " + employee.getFirstName());
                    System.out.println("Last Name: " + employee.getLastName());
                    System.out.println("Email: " + employee.getEmail());
                    System.out.println("Phone: " + employee.getPhone());
                    //
                }
            } else {
                System.out.println("No employee data found in the XML file.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getElementTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return "";
    }
}





