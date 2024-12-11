package DAO;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import confg.Database;

public class UserRepo implements UserDao {
    private Connection connection;
    final String insertQuery = "INSERT INTO user (id, name, username, password) VALUES (?, ?, ?, ?)";
    final String selectQuery = "SELECT * FROM user";
    final String updateQuery = "UPDATE user SET name = ?, username = ?, password = ? WHERE id = ?";
    final String deleteQuery = "DELETE FROM user WHERE id = ?";
    
    public UserRepo() {
        connection = Database.koneksi();
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> show() {
    List<User> ls = null;
    try {
    ls = new ArrayList<User>();
    Statement st = connection.createStatement();
    ResultSet rs = st.executeQuery(selectQuery);
    while(rs.next()) {
    User user = new User();
    user.setId(rs.getString("id"));
    user.setName(rs.getString("name"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    ls.add(user);
    }
    } catch(SQLException e) {
    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
    }
    return ls;
    }

    @Override
    public void update(User user) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(updateQuery);
            st.setString(1, user.getName());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setString(4, user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(deleteQuery);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}