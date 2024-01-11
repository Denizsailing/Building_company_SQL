package org.example.sqlconnection.Factory;

public class MaterialFacade {
    private final MaterialDAO materialDAO;
    private final MaterialEventManager eventManager;

    public MaterialFacade(MaterialDAO materialDAO, MaterialEventManager eventManager) {
        this.materialDAO = materialDAO;
        this.eventManager = eventManager;
    }

    public void addMaterial(Material material) {
        // Implementation of addMaterial method
    }

    public void updateMaterial(Material material) {
        // Implementation of updateMaterial method
    }

    public void deleteMaterial(int materialId) {
        // Implementation of deleteMaterial method
    }
}
