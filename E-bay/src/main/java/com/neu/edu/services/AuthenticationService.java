package com.neu.edu.services;



import com.neu.edu.dao.CustomerDAO;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.LoginCustomer;
import org.mindrot.jbcrypt.BCrypt;


public class AuthenticationService {
	
	public AuthenticationService()
	{
		
	}
	
public Boolean authenticate(LoginCustomer incomingUser) {
		
		
		

		Customer customer = new CustomerDAO().getUserByCustomerName(incomingUser.getUserName());
		System.out.println("FOUND USER in authenticate:" +customer);
		if (customer == null) {
			return false;
		} else {
			//Boolean pwdCheck = BCrypt.checkpw(incomingUser.getPwd(), user.getPwdHash());
			System.out.println("user was found: "+customer.getUserName());
			Boolean pwdCheck = false;
			System.out.println("now matching");
			System.out.println("INCOMING PWD: "+incomingUser.getPassword());
			System.out.println("DB PWD: "+customer.getPassword());
			
			
			
			if (incomingUser.getPassword().equals(customer.getPassword()))
			{
				System.out.println("user matched");
				pwdCheck=true;
			}
			//System.out.println("PWDCHECK: "+pwdCheck);
			

			return pwdCheck;

		}

	}

}
