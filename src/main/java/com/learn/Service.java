package com.learn;

import com.learn.model.QAndAModel;
import com.learn.repository.IRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private List<QAndAModel> questions;
    private int currentQuestionIndex;

    public void QuizService(IRepository repository) {
        questions.add(repository.loadRandomQuestions(3));

        currentQuestionIndex = -1;
    }

    public QAndAModel getNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public boolean checkAnswer(QAndAModel question, String selectedAnswer) {
        if (question != null) {
            return question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer);
        }
        return false;
    }
}
