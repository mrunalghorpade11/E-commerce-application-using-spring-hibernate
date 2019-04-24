package com.neu.edu.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neu.edu.dao.CategoryDAO;
import com.neu.edu.dao.CustomerDAO;
import com.neu.edu.pojo.Category;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.LoginCustomer;
import com.neu.edu.services.AuthenticationService;
import com.neu.edu.utils.SessionChecker;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
//	@Autowired
//	CustomerDAO cusDAO;
	
	@Autowired
	CategoryDAO categoryDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		return "home";
	}
	
	
//	@RequestMapping(value = "/login")
//	public String login()
//	{
//		return "login";
//	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res, LoginCustomer customer) {
		HttpSession session = req.getSession(false);
		if (SessionChecker.checkForUserSession(req) == false) {
			ModelAndView mv = new ModelAndView("login");
			req.setAttribute("customer", customer);
			return mv;
		} else {
			return new ModelAndView("redirect:/category.htm");
		}
	}
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView performLogin(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("customer") @Validated LoginCustomer user, BindingResult bindingResult,
			AuthenticationService authenticationService, CustomerDAO customerDao) {

		if (bindingResult.hasErrors()) {
			System.out.println("login binding error");
			return new ModelAndView("login");
		}
		HttpSession session = req.getSession(false);
			session.setAttribute("loggedInUser", user.getUserName());
		System.out.println("now attempting login: ");
		if (SessionChecker.checkForUserSession(req) == false) {
			System.out.println("beginning authentication:");

			if (authenticationService.authenticate(user) == true) {
				System.out.println("authentication successfull");
				SessionChecker.getSessionForUser(req, user.getUserName());
			//	return new ModelAndView("redirect:/");
//				String role = customer.getRole();
//				user.setRole(role);
				
				//System.out.println(user.getRole());
				if(user.getRole().equalsIgnoreCase("customer"))
				{
					//List<Category> categories = categoryDao.getCategory();
					return new ModelAndView("redirect:/category.htm");
					
				}
				else if(user.getRole().equalsIgnoreCase("supplier"))
					return new ModelAndView("redirect:/supplierview.htm");
				else
					return new ModelAndView("/");
				
				

			} else {
				System.out.println("could not authenticate");
				ModelAndView mv = new ModelAndView("login");
				Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("loginError", "Invalid User Credentials, Please Try again");
				return mv;
			}

		}

		return new ModelAndView("redirect:/");

	}
	
	
	@RequestMapping(value="/category.htm",method=RequestMethod.GET)
	public ModelAndView showCategory(HttpServletRequest request, HttpServletResponse response) {
	
		List<Category> categories = categoryDao.getCategory();
		return new ModelAndView("category","cat",categories);
	}
	
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("customer") != null)
				return new ModelAndView("redirect:/login");
		}
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("customer", new Customer());
		request.setAttribute("customer", new Customer());

		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegister(RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("customer") @Validated Customer customer, BindingResult bindingResult,
			ModelMap map, CustomerDAO customerDao) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");

		}

		//String hashpwd = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
		//customer.setPassword(hashpwd);
		if (customerDao.saveUser(customer)) {
			System.out.println("SUCCSS REGISTER");
			
			return new ModelAndView("redirect:/");
		}

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("registerError", "Duplicates");
		return mv;

		// String pwdHash = BCrypt.hashpw(request.getParameter("pwd"),
		// BCrypt.gensalt());

	}
	
	@RequestMapping(value = "/logout.htm")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	
	
//	@RequestMapping(value = "/register")
//	public String register()
//	{
//		return "register";
//	}
	
	
}
