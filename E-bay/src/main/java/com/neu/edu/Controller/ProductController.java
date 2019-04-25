package com.neu.edu.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.CustomerDAO;
import com.neu.edu.dao.OrderDAO;
import com.neu.edu.dao.ProductDAO;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.LoginCustomer;
import com.neu.edu.pojo.Orders;
import com.neu.edu.pojo.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	OrderDAO orderDao;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showProducts(HttpServletRequest req, HttpServletResponse res, LoginCustomer customer) 
	{
		String category = req.getParameter("category");
		List<Product> products = productDao.getProductbyCategoryID();
		return new ModelAndView(category,"product",products);
	
	}
	
	@RequestMapping(value = "/product/order", method = RequestMethod.GET)
	public ModelAndView orderProduct(HttpServletRequest req, HttpServletResponse res, LoginCustomer customer) 
	{
		//String category = req.getParameter("category");
		String productName = req.getParameter("productName");
		List<Product> products = productDao.getProductbyCategoryName(productName);
		return new ModelAndView("order","product",products);
	
	}
		
	@RequestMapping(value="/product/order/placed", method = RequestMethod.GET)
	public ModelAndView placeOrder(HttpServletRequest req, HttpServletResponse res)
	{
		HttpSession session = req.getSession(false);
		String name = (String)session.getAttribute("loggedInUser");
		System.out.println("logged in user " +name);
		Customer customer =new CustomerDAO().getUserByCustomerName(name);
		//int id = customer.getCustomerID();
		Orders orders = new Orders();
		Date date = new Date();
		orders.setDate(date);
		orders.setCustomer(customer);
		
		//ArrayList<String> gfg = new ArrayList<String>(); 
		List<Orders> abc = new ArrayList<Orders>();
		abc.add(orders);
		customer.setOrder(abc);
		
		
		orderDao.saveOrder(orders);
		try {
		orderDao.sendEmail("mrunal.ghorpade123@gmail.com");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return new ModelAndView("orderSuccess");
		
	}
	
	

}
