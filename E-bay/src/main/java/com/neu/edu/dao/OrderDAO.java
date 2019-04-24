package com.neu.edu.dao;

import java.util.Date;
import java.util.List;

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

}
