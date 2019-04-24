package com.neu.edu.validator;

import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Customer;





public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Customer.class);
    }

	@Override
    public void validate(Object o, Errors errors) {
	
	}
	

	
	
}
