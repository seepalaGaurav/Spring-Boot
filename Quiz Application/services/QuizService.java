package com.example.quizz.services;

import com.example.quizz.Repositories.QuestionRepository;
import com.example.quizz.Repositories.QuizRepository;
import com.example.quizz.models.QuestionModel;
import com.example.quizz.models.QuestionWrapper;
import com.example.quizz.models.QuizModel;
import com.example.quizz.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionModel> questions=questionRepository.findRandomQuestionsByCategory(category, numQ);
//        List<QuestionModel> questions=questionRepository.findRandomQuestionsByCategory(category);
        QuizModel quizz=new QuizModel();
        quizz.setTitle(title);
        quizz.setQuestionModel(questions);
        quizRepository.save(quizz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<QuizModel> quiz= quizRepository.findById(id);
        List<QuestionModel> questionsFromDb=quiz.get().getQuestionModel();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(QuestionModel q:questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<ResponseModel> userResponses) {
        Optional<QuizModel> quiz=quizRepository.findById(id);//or use QuizModel quiz=quizRepository.findById(id).get()-it will throw error if quizz not found.
        List<QuestionModel> questions=quiz.get().getQuestionModel();
        int rightAswersCount=0;
        int i=0;
        for(ResponseModel responses:userResponses){
            if(responses.getResponse().equals(questions.get(i).getRightAnswer()))
                rightAswersCount++;
            i++;
        }
        return new ResponseEntity<>(rightAswersCount,HttpStatus.OK);
    }
}
