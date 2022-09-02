package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Attemptquiz;

@Repository
public class AttemptquizDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public int AddAnswer(Attemptquiz aq)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
			 manager.persist(aq);
			 manager.close();
			 tran.commit();
			 return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}	
	}

}
