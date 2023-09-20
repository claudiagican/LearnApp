package com.learn.repository;

import com.learn.model.QAndAModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

@Component
public class VerbsRepositoryImpl implements IRepository{


    private HashMap<String, String> generateSomeVerbsList(){
        HashMap<String, String> verbs = new HashMap<String, String>();
        verbs.put("laufen", "to run");
        verbs.put("essen", "to eat");
        verbs.put("schlafen", "to sleep");
        verbs.put("machen", "to make");
        verbs.put("konnen", "to can");
        verbs.put("gehen", "to go");
        verbs.put("lesen", "to read");
        verbs.put("kaufen", "to buy");
        verbs.put("reisen", "to travel");

        return verbs;
    }

    @Override
    public QAndAModel loadRandomQuestions(int answersNumber) {

        HashMap<String, String> verbs = generateSomeVerbsList();
        QAndAModel result = new QAndAModel();
        Random rand = new Random();

        result.setQuestion("lesen");
        result.setAnswers(new String[]{"to sleep", "to read", "to buy"});
        result.setCorrectAnswer("to read");

        return result;
    }

    @Override
    public QAndAModel loadFirstQuestions(int answersNumber) {
        return null;
    }


}
