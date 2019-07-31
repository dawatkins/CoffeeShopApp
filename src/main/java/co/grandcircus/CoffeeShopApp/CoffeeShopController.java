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
		session.setAttribute("preference", name);
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
	
}
