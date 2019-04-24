package com.neu.edu.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.Product;

@Controller
public class SupplierController {
	
	@RequestMapping(value="/supplierview.htm", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res)
	{
		return new ModelAndView("supview");
	}
	
	@RequestMapping(value="/supplierAction.htm",method = RequestMethod.GET)
	public ModelAndView performOperation(HttpServletRequest req, HttpServletResponse res,ModelMap model)
	{
		ModelAndView mv = new ModelAndView("addProduct") ;
		String action = req.getParameter("actionParam");
		if(action.equalsIgnoreCase("add"))
		{
//			mv.addObject("customer", new Customer());
			req.setAttribute("addProduct", new Product());
			mv.addObject("addProduct", new Product());
			return new ModelAndView("addProduct");
		}
		else
			return new ModelAndView("redirect:/");
	}
}
