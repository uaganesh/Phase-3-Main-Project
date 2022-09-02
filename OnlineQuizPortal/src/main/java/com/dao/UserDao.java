package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Login;
import com.bean.User;

@Repository
public class UserDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public int signup(Login l)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
			 manager.persist(l);
			 tran.commit();
			 return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	
	public int InsertToUSer(User u)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
			 manager.persist(u);
			 tran.commit();
			 return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
		
	}
	
	public Login checkUser(String email)
	{
		EntityManager manager=emf.createEntityManager(); 
		Login l=manager.find(Login.class,email);
		return l;
		
	}
	
	

}
