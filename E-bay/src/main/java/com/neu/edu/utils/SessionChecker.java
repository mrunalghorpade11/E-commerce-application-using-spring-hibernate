package com.neu.edu.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionChecker {

	
	public static  Boolean checkForUserSession(HttpServletRequest request)
	{
		if(request.getSession(false)!=null)
		{
			System.out.println("session exists");
			
			if(request.getSession().getAttribute("customer")!=null)
			{
				System.out.println("session exists for customer");
				return true;
			}
			System.out.println("but no customer in session");
			return false;
			
				
		}
		
		System.out.println(" no customer in session");
		
		return false;
	}
	
	public static HttpSession getSessionForUser(HttpServletRequest request, String username)
	{
		if(checkForUserSession(request)==false)
		{
			HttpSession session = request.getSession();
			session.setAttribute("customer", username);
			System.out.println("set session for : "+username);
			return session;
		}
		else
		{
			return request.getSession();
		}
	}
	
	
	
	
	
}
