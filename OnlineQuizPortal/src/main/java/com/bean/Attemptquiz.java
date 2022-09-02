package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attemptquiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aqid;
	private String email;
	private int quizid;
	private int qid;
	private String uanswer;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getUanswer() {
		return uanswer;
	}
	public void setUanswer(String uanswer) {
		this.uanswer = uanswer;
	}
	public int getAqid() {
		return aqid;
	}
	@Override
	public String toString() {
		return "Attemptquiz [aqid=" + aqid + ", email=" + email + ", quizid=" + quizid + ", qid=" + qid + ", uanswer="
				+ uanswer + "]";
	}
	
	
}
