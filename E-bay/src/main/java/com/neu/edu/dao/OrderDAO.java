package com.neu.edu.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.neu.edu.pojo.Orders;





public class OrderDAO extends DAO {
	
	public OrderDAO()
	{
		
	}
	
	public void saveOrder(Orders orders) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try
		{
		
		session = getSession();
		tx = session.beginTransaction();
		session.save(orders);
		tx.commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public void sendEmail(String orderEmail)throws EmailException
    {
		String mail = "mrunal.ghorpade123@gmail.com";
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("sameeraghorpade@gmail.com" , "qwerty123@"));
        email.setSSLOnConnect(true);
        email.setFrom("no-reply@msis.neu.edu");
        email.setSubject("Test Mail");
        email.setMsg("Order placed successfully");
        email.addTo(mail);
        email.send();
    }

}
