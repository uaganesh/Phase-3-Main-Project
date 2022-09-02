package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Score;

@Repository
public class ScoreDao {

	@Autowired
	EntityManagerFactory emf;

	public int scoreAdd(String email, String title) {
		try {
			EntityManager manager = emf.createEntityManager();
			System.out.println(email + " " + title);
			Query qry = manager.createQuery("from Score s where s.email=:email and s.title=:title");
			qry.setParameter("email", email);// JPQ
			qry.setParameter("title", title);// JPQ
			Score s = (Score) qry.getSingleResult();
			System.out.println("Value of s=" + s);

			if (s == null) {

				return 0;
			} else {
				int result = s.getScore();
				int newresult = result + 1;
				s.setScore(newresult);
				EntityTransaction tran = manager.getTransaction();
				tran.begin();
				manager.merge(s);
				manager.close();
				tran.commit();
				return 1;
			}
		} catch (Exception e) {
			System.out.println(e);

			System.out.println("exception occured at score class");
			return 0;
		}

	}

	// Retreiving Score

	public String checkScore(String email, String title) {
		try {
			EntityManager manager = emf.createEntityManager();
			System.out.println("Data Recieved For Result check");
			System.out.println(email + " " + title);
			Query qry = manager.createQuery("from Score s where s.email=:email and s.title=:title");
			qry.setParameter("email", email);// JPQ
			qry.setParameter("title", title);// JPQ
			Score s = (Score) qry.getSingleResult();
			manager.close();
			System.out.println("Value of s=" + s);
			if (s == null) {

				return "No Details For the Above Creteria";
			} else {
				String result = String.valueOf(s.getScore());
				return "Score=" + result;

			}
		} catch (Exception e) {
			System.out.println(e);
			return "Details Incorrect";
		}

	}

	public List<Score> getStandingPosition() {
		EntityManager manager = emf.createEntityManager();
		System.out.println("Data Recieved For Result check");
		
		Query qry = manager.createQuery("Select s.email,s.title,s.score from Score s ORDER BY s.score DESC");
		List<Score> listOfScore =qry.getResultList();
		return listOfScore;

	}

}
