package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.neu.edu.pojo.Category;

public class CategoryDAO extends DAO {

	
	public CategoryDAO()
	{
		
	}
	
	public List<Category> getCategory()
	{
		Session session = null;
		Transaction tx = null;
		List<Category> categories = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("from Category");
			 categories = q.list();
			tx.commit();
			return categories;

		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
			return categories;
		} finally {
			if (session != null)
				session.close();
		}
		
		
		
//		List abc = null;
//		return abc;
	}

}
