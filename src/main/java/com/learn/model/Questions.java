package com.learn.model;

import java.util.List;

public class Questions {
    private String name;
    private List<Question> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuestionSet{" +
                "name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}
