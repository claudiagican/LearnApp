package com.learn.repository;

import com.learn.model.QAndAModel;

public interface IRepository {

    QAndAModel loadRandomQuestions(int answersNumber);
    QAndAModel loadFirstQuestions(int answersNumber);
}
