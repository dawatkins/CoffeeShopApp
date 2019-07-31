package co.grandcircus.CoffeeShopApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShopApp.entity.Product;
//import co.grandcircus.foodsorm.entity.Food;


@Repository
@Transactional
public class ProductDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		// String sql = "SELECT * FROM Products";
		return em.createQuery("FROM Product", Product.class).getResultList();
	}
	
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}
	
	public void create(Product item) {
		em.persist(item);
	}
	
	public void delete(Long id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Product item = em.getReference(Product.class, id);
		em.remove(item);
	}
	
	public void update(Product item) {
		em.merge(item);
	}
	
	
	
}
