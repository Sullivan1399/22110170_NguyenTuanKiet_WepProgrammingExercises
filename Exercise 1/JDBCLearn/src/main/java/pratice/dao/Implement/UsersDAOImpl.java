package pratice.dao.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import pratice.config.DBConnectMySQL;
import pratice.dao.IUsersDAO;
import pratice.models.usermodels;

public class UsersDAOImpl extends DBConnectMySQL implements IUsersDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<usermodels> findAll() {
		String sql = "select * from user";

		List<usermodels> list = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next() /* Next từng dòng tới cuối bảng */) {

				usermodels user = new usermodels();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("images"));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public usermodels findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE id = ?";
		usermodels user = new usermodels();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("images"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean findByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";
		usermodels user = new usermodels();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("images"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user.getUsername() != null;
	}

	@Override
	public void insert(usermodels user) {
		String sql = "INSERT INTO user(username, password, email, fullname, images) value (?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(usermodels user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		UsersDAOImpl usersDao = new UsersDAOImpl();
		usersDao.insert(new usermodels("NTK", "1234", "ntk@gmail.com", "Nguyễn Tuấn Kiệt","abc.png"));
		usersDao.insert(new usermodels("abc", "12345", "abc@gmail.com","abcde","hello.png"));
		
		List<usermodels> users = usersDao.findAll();

		for (usermodels user : users) {
			System.out.println(user);
		}
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào ID muốn tìm: ");
		int x = scanner.nextInt();
		usermodels user = usersDao.findById(x);
		System.out.println(user);
	}
}
