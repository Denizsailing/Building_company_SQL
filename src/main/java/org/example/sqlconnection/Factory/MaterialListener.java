package org.example.sqlconnection.Factory;

public interface MaterialListener {
    void onMaterialAdded(Material material);
    void onMaterialUpdated(Material material);
    void onMaterialDeleted(int materialId);
}
