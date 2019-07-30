package co.grandcircus.CoffeeShopApp.dao;

//import org.apache.catalina.realm.JNDIRealm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShopApp.entity.Users;

@Repository
public class UsersDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public void create(Users user) {
		String sql = "INSERT INTO Users	(name, email, password) VALUES(?, ?, ?)";
		jdbc.update(sql, user.getName(), user.getEmail(), user.getPassword());
	}
	
}
