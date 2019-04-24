package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.neu.edu.pojo.Customer;



public class CustomerDAO extends DAO {

	 public CustomerDAO() {
	    }
	 
	 public Boolean saveUser(Customer customer) {
			Session session = null;
			Transaction tx = null;

			try {
				session = getSession();
				tx = session.beginTransaction();
				session.save(customer);
				System.out.println("able to save customer");
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
	 
	 public Customer getUserByCustomerName(String customer) {
			Session session = null;
			Transaction tx = null;
			try {
				session = getSession();
				System.out.println("searching for user by username: "+ customer);
				Query q=getSession().createQuery("from Customer where userName = :userName");
				 q.setString("userName",customer);
//				Criteria cr = session.createCriteria(Customer.class);
//				cr.add(Restrictions.like("email", "%" + user + "%"));
				Customer foundUser = (Customer) q.uniqueResult();
				System.out.println("foundUserName: " + foundUser);
				return foundUser;

			} catch (Exception ex) {
				ex.printStackTrace();
				if(tx!=null)
				tx.rollback();
				return null;
			} finally {
				if (session != null)
					session.close();
			}
		}
	 
	 
//	 public boolean checkCustomer(String userName)
//	 {
//		 try {
//			 super.begin();
//			 Query q=getSession().createQuery("from Customer where userName = :userName");
//			 q.setString("userName",userName);
//			 
//			 List exists = q.list();
//			 super.commit();
//			 if(exists.isEmpty())
//				 return false;
//				 else
//				return true; 
//			 
//			  
//		 }
//		 catch(Exception e)
//		 {
//			 System.out.print(e.getMessage());
//			 return false;
//		 }
//	 }
	 
//	 public Customer get(String fname) {
//	        try {
//	            super.begin();
//	            Query q = getSession().createQuery("from Customer where fname = :username");
//	            q.setString("username", fname);
//	          //  Customer customer = (Customer) q.uniqueResult();
//	            super.commit();
//	            return Customer;
//	        } catch (Exception e) {
//	            super.rollback();
//	            // new UserException("Could not get user with first name " + fname, e);
//	        } finally {
////	            super.close();
//	        }
//	    }
	
	
}
