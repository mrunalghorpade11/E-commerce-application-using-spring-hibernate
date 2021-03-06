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
	
	public Category getCategorybyID(int categoryID)
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Category where categoryID= :categoryID");
			q.setInteger("categoryID",categoryID);
			Category cat =(Category) q.uniqueResult();
					return cat;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public boolean addProduct(String pName, int price,int quantity, int category)
	{
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Product product = new Product();
			product.setProductName(pName);
			product.setPrice(price);
			product.setQuantity(quantity);
			Category cate = getCategorybyID(category);
			product.setCategory(cate);
			session.save(product);
			System.out.println("able to save product");
			tx.commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
		
		
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
	
	public List<Category> getCategory()
	{
		Session session = null;
		Transaction tx = null;
		
		List<Category> category = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Category");
			category =  q.list();
			tx.commit();
			return category;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return category;
		} finally {
			if (session != null)
				session.close();
		}
		
		
		
	}

}
