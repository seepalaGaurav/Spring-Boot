package com.example.quizz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Questions")
public class QuestionModel {
	
	private Integer id;
	private String category;
	private String difficulty;
	private String questionTitle;  
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	//Note:In @column Annotation column name not to be in Camel Case.
	//problem is here bcz if I use camel case it is creating new column with question_title as extra in table bcz we wrote spring.jpa.hibernate.ddl-auto=update in properties file
	//Due to this reason it is not displaying data for questionTitle,rightAnswer as it is looking data under question_title,right_answer 
	//Solution:
	//1)Not to use no camel case.
	//2)Use camel case but name column as question_title(in table creation) for questionTitle at @column(name="questionTitle") &  name column as question_answer/if doesn't work(question_Answer)(in table creation) for rightAnswer at @column(name="rightAnswer")
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY )
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="category",nullable=false)
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="difficulty",nullable=false)
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	@Column(name="option1",nullable=false)
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	@Column(name="option2",nullable=false)
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	@Column(name="option3",nullable=false)
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	@Column(name="option4",nullable=false)
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	@Column(name="questiontitle",nullable=false)
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
	@Column(name="rightanswer",nullable=false)
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
}
