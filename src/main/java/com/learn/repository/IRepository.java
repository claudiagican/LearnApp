package com.learn.repository;

import com.learn.model.QAndAModel;

public interface IRepository {

    QAndAModel loadRandomQuestions(int questionsNumber);
    QAndAModel loadFirstQuestions(int questionsNumber);
}
