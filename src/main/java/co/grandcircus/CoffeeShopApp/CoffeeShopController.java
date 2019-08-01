package co.grandcircus.CoffeeShopApp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShopApp.dao.ProductDao;
import co.grandcircus.CoffeeShopApp.dao.UserRepository;
import co.grandcircus.CoffeeShopApp.dao.UsersDao;
import co.grandcircus.CoffeeShopApp.entity.Product;
import co.grandcircus.CoffeeShopApp.entity.Users;




@Controller
public class CoffeeShopController {
	
	@Autowired
	private UserRepository dao;
	
	@Autowired
	private UsersDao userdao;
	
	@Autowired
	private ProductDao productdao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/products")
	public ModelAndView showProducts() {
		List<Product> product = productdao.findAll();
		return new ModelAndView("products", "products", product);
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
//	@PostMapping("/register")
//	public ModelAndView addRegister(Users user) {
//		userdao.create(user);
//		return new ModelAndView("redirect:/");
//	}
	
	@PostMapping("/register-results")
	public ModelAndView printResults(Users name, HttpSession session) {
		userdao.create(name);
		session.setAttribute("user", name);
		return new ModelAndView("register-results");
	}
	
	@RequestMapping("/products/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		productdao.delete(id);
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/product/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("add-product", "title", "Add a Food");
	}
	
	@PostMapping("/product/create")
	public ModelAndView submitCreateForm(Product item) {
		productdao.create(item);
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/product/update")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("product-form");
		mav.addObject("product", productdao.findById(id));
		mav.addObject("title", "Edit Product");
		return mav;
	}
	
	@PostMapping("/product/update")
	public ModelAndView submitEditForm(Product item) {
		productdao.update(item);
		return new ModelAndView("redirect:/products");
	}
	
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}
	

	@PostMapping("/login")
	public ModelAndView submitLogin(
		@RequestParam("email") String email,
		@RequestParam("password") String password,
		HttpSession session
			) {
		
		// check the database for the user that matches both email and password
		Users user = dao.findByEmailAndPassword(email, password);
		System.out.println(user);
		
		// if not found, show the form again with error message
		if (user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password.");
		}
		
		// "login" just means adding the user to the session
		session.setAttribute("user", user);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		// This clears the session and starts a brand new clean one.
		session.invalidate();
		
		return new ModelAndView("redirect:/");
	}
	
}
