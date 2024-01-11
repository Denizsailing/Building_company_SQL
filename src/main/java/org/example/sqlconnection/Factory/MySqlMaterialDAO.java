package org.example.sqlconnection.Factory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlMaterialDAO implements MaterialDAO {
    private final DatabaseConnectionFactory connectionFactory;

    public MySqlMaterialDAO(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void addMaterial(Material material) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO materials (id, name) VALUES (?, ?)")) {
            statement.setInt(1, material.getId());
            statement.setString(2, material.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMaterial(Material material) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE materials SET name = ? WHERE id = ?")) {
            statement.setString(1, material.getName());
            statement.setInt(2, material.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMaterial(int materialId) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM materials WHERE id = ?")) {
            statement.setInt(1, materialId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> getAllMaterials() {
        List<Material> materials = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM materials")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Material material = new Material(id, name, 0.0, 0);

                materials.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    @Override
    public Material getMaterialById(int materialId) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM materials WHERE id = ?")) {
            statement.setInt(1, materialId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    return  new Material(id, name, 0.0, 0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


