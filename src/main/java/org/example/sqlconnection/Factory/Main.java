package org.example.sqlconnection.Factory;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create the necessary objects using the Factory pattern
        DatabaseConnectionFactory connectionFactory = new MySqlConnectionFactory();

        // Create the necessary objects using the Abstract Factory pattern
        DatabaseAccessFactory accessFactory = new MySqlConnectionAccessFactory(connectionFactory);

        // Create the necessary objects using the Builder pattern
        MaterialBuilder materialBuilder = new MaterialBuilder()
                .setId(1)
                .setName("Material 1")
                .setUnitPrice(10.0)
                .setQuantityInStock(100);
        Material material = materialBuilder.build();

        // Create the necessary objects using the Proxy pattern
        MaterialDAO materialDAO = new MySqlMaterialDAO(connectionFactory);
        MaterialDAOProxy materialDAOProxy = new LoggingMaterialDAOProxy(materialDAO);

        // Create the necessary objects using the Strategy pattern
        MaterialPriceCalculator priceCalculator = new StandardMaterialPriceCalculator();

        // Create the necessary objects using the Facade pattern
        MaterialEventManager eventManager = new MaterialEventManager();
        MaterialFacade materialFacade = new MaterialFacade(materialDAOProxy, eventManager);

        // Create the necessary objects using the MVC pattern
        MaterialController materialController = new MaterialController(materialFacade);
        eventManager.addListener(materialController);

        // Perform operations
        materialController.addMaterial(material);
        materialController.updateMaterial(material);
        materialController.deleteMaterial(1);

        // Get all materials
        List<Material> materials = materialDAOProxy.getAllMaterials();
        for (Material m : materials) {
            double price = priceCalculator.calculatePrice(m);
            System.out.println("Material: " + m.getName() + ", Price: " + price);
        }
    }
}
