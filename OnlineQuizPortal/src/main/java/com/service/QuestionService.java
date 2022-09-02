package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.bean.Question;
import com.dao.QuestionDao;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public String StoreQuestionDetails(Question q)
	{
		int result=questionDao.addQuestion(q);
		if(result==1)
		{
			return "Question Successfully Added";
		}
		else
		{
			return "Error occured! Try Again";
		}
	}
	
	public Question findQuestionById(int id)
	{
		return questionDao.getQuestionDetails(id);
		
	}

	
	
}
