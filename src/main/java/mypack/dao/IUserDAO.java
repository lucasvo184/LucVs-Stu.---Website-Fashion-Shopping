package mypack.dao;

import java.util.List;
import mypack.model.User;

public interface IUserDAO {
	
	List<User> findAll();
	
	User findByEmail(String email);
	
	void insert(User u);
}
