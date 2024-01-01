package com.example.quizz.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="quizz")
public class QuizModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<QuestionModel> questionModel;

    public List<QuestionModel> getQuestionModel() {
        return questionModel;
    }

    public void setQuestionModel(List<QuestionModel> questionModel) {
        this.questionModel = questionModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="title",nullable=false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
