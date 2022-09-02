package com.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.Question;


@Repository
public class QuestionDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public int addQuestion(Question q)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
			 manager.persist(q);
			 manager.close();
			 tran.commit();
			 return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}
	
	public Question getQuestionDetails(int id)
	{
		
		EntityManager manager=emf.createEntityManager();  //equals to session in HIbernate 
		Question q=manager.find(Question.class,id);     //session.get(Emploee.class,id)
		manager.close();
		return q;
		 
	}
	
	public Question getCorrectAnswer(int qid)
	{

		EntityManager manager=emf.createEntityManager();  //equals to session in HIbernate 
		Question q=manager.find(Question.class,qid);  
		manager.close();//session.get(Emploee.class,id)
		return q;
		
		
	}

}
