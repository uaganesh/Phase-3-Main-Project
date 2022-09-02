package com.dao;


import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.Quiz;

@Repository
public class QuizDao {
	
	@Autowired
	EntityManagerFactory emf;
   
	public int addQuiz(Quiz quiz)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
			 manager.persist(quiz);
			 manager.close();
			 tran.commit();
			 return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}
	
	public Quiz getTitle(int quizid)
	{

		EntityManager manager=emf.createEntityManager();  //equals to session in HIbernate 
		Quiz quiz=manager.find(Quiz.class,quizid);     //session.get(Emploee.class,id)
		manager.close();
		return quiz;
		
		
	}
	
	
	public List<Quiz> getAllQuizDetails()
	{
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createQuery("select e from Quiz e");    //JPQ
		List<Quiz> listOfQuiz=qry.getResultList();
		manager.close();
		return listOfQuiz;
		
	}
	
	
}
