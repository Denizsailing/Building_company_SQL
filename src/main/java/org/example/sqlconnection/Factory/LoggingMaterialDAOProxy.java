package org.example.sqlconnection.Factory;
import java.util.List;
public class LoggingMaterialDAOProxy implements MaterialDAOProxy {
    private final MaterialDAO materialDAO;

    public LoggingMaterialDAOProxy(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    @Override
    public void logAccess() {
        // Implementasyon
    }

    @Override
    public void addMaterial(Material material) {
        logAccess();
        materialDAO.addMaterial(material);
    }

    @Override
    public void updateMaterial(Material material) {
        logAccess();
        materialDAO.updateMaterial(material);
    }

    @Override
    public void deleteMaterial(int materialId) {
        logAccess();
        materialDAO.deleteMaterial(materialId);
    }

    @Override
    public List<Material> getAllMaterials() {
        logAccess();
        return materialDAO.getAllMaterials();
    }

    @Override
    public Material getMaterialById(int materialId) {
        logAccess();
        return materialDAO.getMaterialById(materialId);
    }
}
