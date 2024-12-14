package DAO;

import model.Service;
import confg.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepo {

    private Connection connection;
    final String insertQuery = "INSERT INTO service (id, name, description, price) VALUES (?, ?, ?, ?)";
    final String selectQuery = "SELECT * FROM service";
    final String updateQuery = "UPDATE service SET name = ?, description = ?, price = ? WHERE id = ?";
    final String deleteQuery = "DELETE FROM service WHERE id = ?";

    public ServiceRepo() {
        connection = Database.koneksi();
    }

    public void addService(Service service) {
        try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            stmt.setString(1, service.getId());
            stmt.setString(2, service.getStatus());
            stmt.setString(3, service.getJenis());
            stmt.setDouble(4, service.getHarga());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getString("id"));
                service.setStatus(rs.getString("status"));
                service.setJenis(rs.getString("jenis"));
                service.setHarga(rs.getDouble("price"));
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public List<Service> show() {
        return getAllServices();
    }

    public void updateService(Service service) {
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setString(1, service.getId());
            stmt.setString(2, service.getStatus());
            stmt.setString(3, service.getJenis());
            stmt.setDouble(4, service.getHarga());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteService(String id) {
        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
