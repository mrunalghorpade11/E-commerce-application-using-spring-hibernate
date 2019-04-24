package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.neu.edu.pojo.Category;
import com.neu.edu.pojo.Product;

public class ProductDAO extends DAO {
	
	
	public ProductDAO()
	{

	}

	
	public List<Product> getProductbyCategoryID()
	{
		Session session = null;
		Transaction tx = null;
		
		List<Product> product = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Product where category_id = :categoryID");
			q.setInteger("categoryID", 1);
			product =  q.list();
			tx.commit();
			return product;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return product;
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}
	
	public List<Product> getProductbyCategoryName(String name)
	{
		Session session = null;
		Transaction tx = null;
		
		List<Product> product = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Product where productName = :productName");
			q.setString("productName", name);
			product =  q.list();
			tx.commit();
			return product;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return product;
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}

}
