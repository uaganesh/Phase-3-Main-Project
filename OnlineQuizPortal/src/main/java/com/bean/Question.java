package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int qid;
private String question;
private String op1;
private String op2;
private String op3;
private String correctanswer;
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getOp1() {
	return op1;
}
public void setOp1(String op1) {
	this.op1 = op1;
}
public String getOp2() {
	return op2;
}
public void setOp2(String op2) {
	this.op2 = op2;
}
public String getOp3() {
	return op3;
}
public void setOp3(String op3) {
	this.op3 = op3;
}
public String getCorrectanswer() {
	return correctanswer;
}
public void setCorrectanswer(String correctanswer) {
	this.correctanswer = correctanswer;
}
public int getQid() {
	return qid;
}

@Override
public String toString() {
	return "Question [qid=" + qid + ", question=" + question + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
			+ ", correctanswer=" + correctanswer + "]";
}



	
	
}
