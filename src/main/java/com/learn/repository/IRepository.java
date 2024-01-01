package com.learn.repository;

import com.learn.model.Question;

import java.util.List;

public interface IRepository {

    List<String> listOfAvailableQuizzes();

    List<Question> loadQuestions(String source);
}
