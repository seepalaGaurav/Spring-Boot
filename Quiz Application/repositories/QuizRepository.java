package com.example.quizz.Repositories;

import com.example.quizz.models.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizModel,Integer> {

}
