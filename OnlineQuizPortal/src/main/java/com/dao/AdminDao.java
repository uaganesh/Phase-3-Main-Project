package com.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.Login;

@Repository
public class AdminDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public Login checkAdmin(String email)
	{
		EntityManager manager=emf.createEntityManager(); 
		Login user=manager.find(Login.class,email);
		return user;
		
	}
	
	public int updatePassword(Login l)
	{
	EntityManager manager=emf.createEntityManager();
	Login log=manager.find(Login.class,l.getEmail());
	EntityTransaction tran=manager.getTransaction();
	if(log==null)
	{
		return 0;
	}
	else
	{
		log.setPassword(l.getPassword());
		tran.begin();
		 manager.merge(log);
		tran.commit();
		return 1;
	}
	}
}
