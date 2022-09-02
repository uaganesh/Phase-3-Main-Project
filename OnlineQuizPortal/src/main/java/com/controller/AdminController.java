package com.controller;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.bean.User;
import com.service.AdminService;
import com.service.QuestionService;
import com.service.QuizService;
import com.service.ScoreService;
import com.service.UserService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService onlineQuizService;
	
	@Autowired
    QuestionService questionService;
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	ScoreService scoreService;

	// http://localhost:8080/admin/signin Admin Login
	@PostMapping(value = "/signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validateAdmin(@RequestBody Login login) {

		return onlineQuizService.checkAdminUser(login.getEmail(), login.getPassword());

	}

	// http://localhost:8080/admin/changepassword
	@PostMapping(value = "/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String changePassword(@RequestBody Login login) {

		return onlineQuizService.changePassword(login);

	}

	// http://localhost:8080/admin/addQuestion
	@PostMapping(value = "/addQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeQuestionDetails(@RequestBody Question q) {
		
		if((q.getQuestion().equals("null"))||(q.getOp1().equals("null"))||(q.getOp2().equals("null"))||(q.getOp3().equals("null"))||(q.getCorrectanswer().equals("null")))
		{
			return "Details Incomplete";
		}
		else
		{
			return questionService.StoreQuestionDetails(q);
		}
		
	}
	
	// http://localhost:8080/admin/findQuestionById/1
	@PostMapping(value = "/findQuestionById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Question findQuestionById(@PathVariable("id") int id) {
		
		Question q=questionService.findQuestionById(id);
	     if(q==null)
	     {
	    	 return null;
	     }
	     else
	     {
	    	 return q;
	     }
		
	}
	
	//http://localhost:8080/admin/createQuiz
	@PostMapping(value = "/createQuiz", consumes = MediaType.APPLICATION_JSON_VALUE)
     public String insertInQuiz(@RequestBody Quiz quiz)
     {
		if(quiz==null)
		{
		return null;	
		}
		else
		{
		return quizService.insertQuizDetails(quiz);
		}
     }
	
	//http://localhost:8080/admin/standingPosition
	@PostMapping(value = "/standingPosition", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Score> StandingPosition()
    {
		return scoreService.getRank();
    }
     
}
