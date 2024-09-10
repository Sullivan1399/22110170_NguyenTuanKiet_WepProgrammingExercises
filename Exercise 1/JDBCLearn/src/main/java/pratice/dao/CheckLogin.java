package pratice.dao;

import pratice.config.DBConnectMySQL;
import pratice.dao.Implement.UsersDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckLogin extends DBConnectMySQL {
    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            UsersDAOImpl usersDAO = new UsersDAOImpl();
            boolean user = usersDAO.findByUsername(username);
            if (user == false) {
                throw new Exception("User not found.");
            }
            else if (username != null && password != null) {
                conn = super.getDatabaseConnection();
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
            else if (username == null || password == null) {
                throw new Exception("Username or password is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        CheckLogin checkLogin = new CheckLogin();
        System.out.println(checkLogin.checkLogin("NTK", "1234"));
    }
}
