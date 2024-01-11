package org.example.sqlconnection.Factory;

public class MaterialController implements MaterialListener {
    private final MaterialFacade materialFacade;

    public MaterialController(MaterialFacade materialFacade) {
        this.materialFacade = materialFacade;
    }

    // Implementation of methods in the MaterialListener interface

    @Override
    public void onMaterialAdded(Material material) {
        // Implementation of onMaterialAdded method
    }

    @Override
    public void onMaterialUpdated(Material material) {
        // Implementation of onMaterialUpdated method
    }

    @Override
    public void onMaterialDeleted(int materialId) {

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
