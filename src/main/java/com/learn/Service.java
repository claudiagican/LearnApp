package com.learn;

import com.learn.model.Question;
import com.learn.repository.IRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private List<Question> questions;
    private int currentQuestionIndex;

    public void QuizService(IRepository repository) {
//        questions.add(repository.loadRandomQuestion(3));

        currentQuestionIndex = -1;
    }

    public Question getNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {

            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public boolean checkAnswer(Question question, String selectedAnswer) {
        if (question != null) {
            return question.getAnswer().equalsIgnoreCase(selectedAnswer);
        }
        return false;
    }
}
