package com.learn.repository;

import com.learn.model.Question;
import com.learn.model.QuizQuestion;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryRepositoryImpl implements IRepository{


    @Override
    public List<Question> loadRandomQuestion() {

        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question("laufen", "to run"));
        questions.add(new Question("laufen", "to operate"));
        questions.add(new Question("essen", "to eat"));
        questions.add(new Question("schlafen", "to sleep"));
        questions.add(new Question("machen", "to make"));

        return questions;
    }

}
