package com.learn.model;

import java.util.List;

public class QuizQuestion {

    private Question question;
    private List<String> possibleAnswers;

    public QuizQuestion(Question question, List<String> possibleAnswers) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }


    public Question getQuestion() {
        return question;
    }
}
