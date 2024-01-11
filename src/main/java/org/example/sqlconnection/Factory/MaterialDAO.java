package org.example.sqlconnection.Factory;

import java.util.List;

public interface MaterialDAO {
    void addMaterial(Material material);
    void updateMaterial(Material material);
    void deleteMaterial(int materialId);
    List<Material> getAllMaterials();
    Material getMaterialById(int materialId);
}
