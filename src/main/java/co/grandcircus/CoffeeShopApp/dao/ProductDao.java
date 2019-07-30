package co.grandcircus.CoffeeShopApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShopApp.entity.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM Products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}
	
	
}
