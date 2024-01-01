package com.example.quizz.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizz.models.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel,Integer>{
	
	List<QuestionModel> findByCategory(String category);
//JPQL
	@Query(value = "SELECT * FROM questions q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
	List<QuestionModel> findRandomQuestionsByCategory(String category,int numQ);



}
