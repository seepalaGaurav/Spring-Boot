package com.example.quizz.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizz.Repositories.QuestionRepository;
import com.example.quizz.models.QuestionModel;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public ResponseEntity<List<QuestionModel>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<QuestionModel>> getQuestionsByCategory(String category){
		try {
			return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<String> add(QuestionModel question) {
		try {
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
		}

	}
	public void deleteQuestionById(int id){
			try{
				questionRepository.deleteById(id);
				System.out.println(HttpStatus.OK);
			}
			catch(Exception e){
				System.out.println(HttpStatus.BAD_REQUEST);
			}
		}
	}
}
