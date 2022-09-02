package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Attemptquiz;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.dao.AttemptquizDao;
import com.dao.QuestionDao;
import com.dao.QuizDao;
import com.dao.ScoreDao;

@Service
public class AttemptquizService {
	
	@Autowired
	AttemptquizDao attemptquizdao;
	
	@Autowired
     QuestionDao questionDao;
	
	@Autowired
	ScoreDao scoreDao;
	
	@Autowired
	QuizDao quizDao;
	
	public String AttemptQuizQuestions(Attemptquiz aq)
	{
		int result=attemptquizdao.AddAnswer(aq);
		if(result==1)
		{
			//Getting Correct Answer From Question Table and Cross Checking
			Question q=questionDao.getCorrectAnswer(aq.getQid());
			
		    if(q.getCorrectanswer().equals(aq.getUanswer()))
		    {
		    	
		    	//Finding Title From Quiz Table 
		    	Quiz quiz=quizDao.getTitle(aq.getQuizid());
		    	System.out.println("Answer is correct");
		    	System.out.println("Before Insertion");
		    	System.out.println(aq.getEmail());
		    	System.out.println(quiz.getTitle());
		    	
		    	//Since Answer is Correct Inserting it into Score Table 
		    	int result1=scoreDao.scoreAdd(aq.getEmail(), quiz.getTitle());
		    	if(result1==1)
		    	{
		    		System.out.println("Score Updated");
		    		return "Congrats! Correct Answer";
		    	}
		    	else
		    	{
		    		System.out.println("Error Occured at ScoreDao");
		    		return "Error Occured at ScoreDao";
		    	}
		    	
		    	
		    }
		    else
		    {
		    	return "Answer Wrong";
		    }
			
			
		}
		else
		{
			return "Error occured! Try Again";
		}
	}

}
