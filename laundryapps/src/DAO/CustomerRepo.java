package DAO;

import model.Customer;
import confg.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {

    private Connection connection;
    final String insertQuery = "INSERT INTO customer (id, name, email, phone) VALUES (?, ?, ?, ?)";
    final String selectQuery = "SELECT * FROM customer";
    final String updateQuery = "UPDATE customer SET name = ?, email = ?, phone = ? WHERE id = ?";
    final String deleteQuery = "DELETE FROM customer WHERE id = ?";

    public CustomerRepo() {
        connection = Database.koneksi();
    }

    public void addCustomer(Customer customer) {
        try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            stmt.setString(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAlamat());
            stmt.setString(4, customer.getNomorHp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                Customer customer = new Customer(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("alamat"),
                    rs.getString("nomorHp")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void updateCustomer(Customer customer) {
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setString(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAlamat());
            stmt.setString(4, customer.getNomorHp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String id) {
        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
