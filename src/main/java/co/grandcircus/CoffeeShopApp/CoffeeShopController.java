package co.grandcircus.CoffeeShopApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShopApp.dao.ProductDao;
import co.grandcircus.CoffeeShopApp.dao.UsersDao;
import co.grandcircus.CoffeeShopApp.entity.Product;
import co.grandcircus.CoffeeShopApp.entity.Users;


@Controller
public class CoffeeShopController {
	
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
		List<Product> products = productdao.findAll();
		return new ModelAndView("products");
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@PostMapping("/register")
	public ModelAndView addRegister(Users user) {
		userdao.create(user);
		return new ModelAndView("redirect:/");
	}
	
//	@PostMapping("/register")
//	public ModelAndView showRegistrationResults(
//		@RequestParam("name") String name,
//		@RequestParam("email") String email,
//		@RequestParam("password") String password){
//			ModelAndView mav = new ModelAndView("register-results");
//			mav.addObject("name", name);
//			mav.addObject("email", email);
//			mav.addObject("password", password);
//			return mav;
//	}
	
	
}
