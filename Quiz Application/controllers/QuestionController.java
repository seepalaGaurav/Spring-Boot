package com.example.quizz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizz.models.QuestionModel;
import com.example.quizz.services.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionModel>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")   
	public ResponseEntity<List<QuestionModel>> getQuestionsByCategory(@PathVariable String category){
		//if name in @GetMapping[we have category/{cat}] is not same to that of parameter category then use @PathVariable("cat")
		//So that it says that take "cat" from url and give it to the parameter category 
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> add(@RequestBody QuestionModel question) {
		return questionService.add(question);
	}
	@DeleteMapping("/deleteQuestion/{id}")
	public void deleteQuestion(@PathVariable int id){
			questionService.deleteQuestionById(id);
	}
}
