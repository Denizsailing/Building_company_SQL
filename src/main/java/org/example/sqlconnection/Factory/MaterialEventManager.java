package org.example.sqlconnection.Factory;
import java.util.ArrayList;
import java.util.List;

public class MaterialEventManager {
    private final List<MaterialListener> listeners = new ArrayList<>();

    public void addListener(MaterialListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MaterialListener listener) {
        listeners.remove(listener);
    }

    public void notifyMaterialAdded(Material material) {
        for (MaterialListener listener : listeners) {
            listener.onMaterialAdded(material);
        }
    }

    public void notifyMaterialUpdated(Material material) {
        for (MaterialListener listener : listeners) {
            listener.onMaterialUpdated(material);
        }
    }

    public void notifyMaterialDeleted(int materialId) {
        for (MaterialListener listener : listeners) {
            listener.onMaterialDeleted(materialId);
        }
    }
}
