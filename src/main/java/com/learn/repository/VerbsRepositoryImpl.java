package com.learn.repository;

import com.learn.model.Question;
import com.learn.model.QuizQuestion;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VerbsRepositoryImpl implements IRepository{


    private List<Question> loadSomeVerbsList(){

        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question("laufen", "to run"));
        questions.add(new Question("laufen", "to operate"));
        questions.add(new Question("essen", "to eat"));
        questions.add(new Question("schlafen", "to sleep"));
        questions.add(new Question("machen", "to make"));

        return questions;
    }

    @Override
    public QuizQuestion loadRandomQuestion() {

        List<Question> questions = loadSomeVerbsList();
        Collections.shuffle(questions, new Random());

        Question chosenQuestion = questions.get(0);

        List<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add(chosenQuestion.getAnswer());
        possibleAnswers.add(questions.get(1).getAnswer());
        possibleAnswers.add(questions.get(2).getAnswer());
        Collections.shuffle(possibleAnswers);

        return new QuizQuestion(chosenQuestion, possibleAnswers);
    }

}
