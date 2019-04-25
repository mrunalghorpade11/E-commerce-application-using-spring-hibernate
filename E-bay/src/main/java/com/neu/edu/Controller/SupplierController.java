package com.neu.edu.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.neu.edu.dao.ProductDAO;
import com.neu.edu.pojo.Category;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.LoginCustomer;
import com.neu.edu.pojo.Product;
import com.neu.edu.pojo.Supplier;



@Controller
public class SupplierController {
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@RequestMapping(value="/supplierview.htm", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res)
	{
		return new ModelAndView("supview");
	}
	
	@RequestMapping(value="/supplierAction.htm",method = RequestMethod.GET)
	public ModelAndView performOperation(HttpServletRequest req, HttpServletResponse res,ModelMap model)
	{
		List<Category> category = categoryDao.getCategory();
	//	ModelAndView mv = new ModelAndView() ;
		String action = req.getParameter("actionParam");
		model.addAttribute("product", new Product());
		model.addAttribute("category",category);
		req.setAttribute("product", new Product());
		if(action.equalsIgnoreCase("add"))
		{
//			mv.addObject("customer", new Customer());
			//mv.addObject("addProduct", new Product());
			return new ModelAndView("addProduct");
		}
		else
			return new ModelAndView("redirect:/");
	}
	 @ModelAttribute("categoryList")
	   public Map<String, Integer> getCategoryList() {
		 List<Category> category = productDao.getCategory();
	      Map<String, Integer> categoryList = new HashMap<String, Integer>();
	      for(Category cat:category)
	      { 
	    	  categoryList.put(cat.getCategoryName(), cat.getCategoryID());
	      }
	    
	      return categoryList;
	   
	}
	 
	 @RequestMapping(value="/supplierAction",method = RequestMethod.POST)
	 public ModelAndView processAddProduct(HttpServletRequest request)
	 {
		 HttpSession session = request.getSession();
		 String productName = request.getParameter("productName");
		 int productPrice =Integer.parseInt(request.getParameter("ProductPrice"));
		 int quantity =  Integer.parseInt(request.getParameter("quantity"));
		 int category = Integer.parseInt(request.getParameter("category"));
		 productDao.addProduct(productName, productPrice, quantity,category);
		 LoginCustomer user = (LoginCustomer) session.getAttribute("loggedInUser");
		 Supplier supplier = new Supplier();
		 String username = user.getUserName();
		  //supplier.setSupplierName(username);
		 
		 return new ModelAndView("productAddSuccess");
		 
		 
	 }
	 
//	 @RequestMapping(value="/supplierAction",method = RequestMethod.POST)
//	 public ModelAndView processAddProduct(RedirectAttributes redirectAttributes, HttpServletRequest request,
//				HttpServletResponse response, @ModelAttribute("product") Product product, BindingResult bindingResult,
//				ModelMap map, ProductDAO productDao) { 
//		 
//		 
//		 
//		 if (bindingResult.hasErrors()) {
//				return new ModelAndView("addProduct");
//
//			}
//		 
//		 
//		 if (productDao.addProduct(product)) {
//				System.out.println("SUCCSS SAVING PRODUCT");
//				
//				return new ModelAndView("productAddSuccess");
//			}
//		 
//		 
//		 return new ModelAndView("productAddSuccess");
//	 }
	 
}
