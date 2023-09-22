package com.learn.model;

public class Question {
    private String content;
    private String answer;

    public Question(String content, String answer) {
        this.content = content;
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

}
