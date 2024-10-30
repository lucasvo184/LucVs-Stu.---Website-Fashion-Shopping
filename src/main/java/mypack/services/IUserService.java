package mypack.services;

import mypack.model.*;

public interface IUserService {
	User Login(String email, String password);
	
	boolean SignUp(String email, String password, String name, String phone);
	
	User FindByEmail(String email);
}
