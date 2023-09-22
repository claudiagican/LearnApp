package com.learn.repository;

import com.learn.model.QuizQuestion;

public interface IRepository {

    QuizQuestion loadRandomQuestion ();
}
