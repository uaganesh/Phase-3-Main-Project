package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Attemptquiz;
import com.bean.Login;
import com.bean.Quiz;
import com.bean.Score;
import com.bean.User;
import com.service.AttemptquizService;
import com.service.QuizService;
import com.service.ScoreService;
import com.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AttemptquizService attemptquizservice;
	
	@Autowired
	ScoreService scoreService;
	
	@Autowired
	QuizService quizService;

	// http://localhost:8080/user/signup
	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeUserOnLoginandUser(@RequestBody User u) {
		return userService.StoreUserDetails(u);
	}

	// http://localhost:8080/user/signin
	@PostMapping(value = "/signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String LoginUser(@RequestBody Login l) {
		return userService.checkUser(l.getEmail(), l.getPassword());
	}

	// http://localhost:8080/user/takequiz
	@PostMapping(value = "/takequiz", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String takeQuiz(@RequestBody Attemptquiz attemptquiz) {
		return attemptquizservice.AttemptQuizQuestions(attemptquiz);
	}
	
	
	
	// http://localhost:8080/user/quizlist
			@PostMapping(value = "quizlist", consumes = MediaType.APPLICATION_JSON_VALUE)
			public List<Quiz> getAllQuizDetailsFromDB()
			{
			  return quizService.getQuizDetails();
				
			}
	
	// http://localhost:8080/user/checkresult
		@PostMapping(value = "checkresult", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String takeQuiz(@RequestBody Score score) {
			return scoreService.scoreCheck(score);
		}

}
