package DAO;

import model.Customer;
import java.util.List;

public interface CustomerDao {
    void save(Customer customer);
    void update(Customer customer);
    void delete(String id);
    List<Customer> show();
}