package org.example.sqlconnection;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        String xmlFilePath = "C:\\Users\\deniz\\UniqueWordsCounter\\Building_company_SQL\\src\\main\\resources\\building_company\\building_company\\employees.xml";
        String xsdFilePath = "C:\\Users\\deniz\\UniqueWordsCounter\\Building_company_SQL\\src\\main\\resources\\building_company\\building_company\\employees.xsd";

        if (validateXML(xmlFilePath, xsdFilePath)) {
            System.out.println("XML file is valid.");
        } else {
            System.out.println("XML file is not valid.");
        }
    }

    public static boolean validateXML(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            File xsdFile = new File(xsdFilePath);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            Source xmlFile = new StreamSource(new File(xmlFilePath));
            validator.validate(xmlFile);
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
