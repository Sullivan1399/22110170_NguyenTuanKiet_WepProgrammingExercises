package pratice.dao;

import java.util.List;

import pratice.models.usermodels;

public interface IUsersDAO {
	List<usermodels> findAll();
	usermodels findById(int id);
	boolean findByUsername(String username);
	void insert(usermodels user);
	void update(usermodels user);
	void delete(int id);
}
