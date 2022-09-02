package com.service;

import java.util.List;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.bean.Question;
import com.bean.Quiz;
import com.dao.QuizDao;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	public String insertQuizDetails(Quiz quiz)
	{
		int result=quizDao.addQuiz(quiz);
		if(result==1)
		{
			return "Quiz Successfully Set";
		}
		else
		{
			return "Error occured! Try Again";
		}
	}
	
	public List<Quiz> getQuizDetails()
	{
		
			return quizDao.getAllQuizDetails();
		
	}
	 
	
	
	
	}

