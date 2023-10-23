package com.learn;

import com.learn.model.Question;
import com.learn.model.QuizQuestion;
import com.learn.repository.IRepository;
import com.learn.repository.InMemoryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private InMemoryRepositoryImpl repository;
    private int currentQuestionIndex;

    private int score;

    @Autowired
    public Service(IRepository repository) {
        currentQuestionIndex = -1;
    }

    public QuizQuestion getNextQuestion() {

        currentQuestionIndex++;

        if (currentQuestionIndex < 5) {

            List<Question> questions = repository.loadRandomQuestion();
            Collections.shuffle(questions, new Random());

            Question chosenQuestion = questions.get(0);

            List<String> possibleAnswers = new ArrayList<String>();
            possibleAnswers.add(chosenQuestion.getAnswer());
            possibleAnswers.add(questions.get(1).getAnswer());
            possibleAnswers.add(questions.get(2).getAnswer());
            Collections.shuffle(possibleAnswers);

            return new QuizQuestion(chosenQuestion, possibleAnswers);
        }
        return null;
    }

    public void checkAnswer(Question question, String selectedAnswer) {
        if (question != null) {
            if (question.getAnswer().equalsIgnoreCase(selectedAnswer)) {
                score++;
            }
        }
    }

    public int getCurrentQuestionIndex(){
        return currentQuestionIndex;
    }

    public void resetCurrentQuestionIndex() {
        currentQuestionIndex = -1;
    }

    public int getScore(){
        return score;
    }

    public void resetScore(){
        score = 0;
    }
}
