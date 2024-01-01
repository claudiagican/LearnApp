package com.learn;

import com.learn.model.Question;
import com.learn.model.QuizQuestion;
import com.learn.repository.IRepository;
import com.learn.repository.JSONRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class LearnAppService {

    @Autowired
    private IRepository repository;
    private int currentQuestionIndex;

    private int score;

    private List<Question> questionsFromRepo;

    @Autowired
    public LearnAppService(JSONRepository repository) {
        this.repository = repository;
        currentQuestionIndex = -1;
        questionsFromRepo = null;
    }

    public List<String> listOfAvailableQuizzes(){
        return repository.listOfAvailableQuizzes();
    }

    /**
     * Generate a quiz question shuffling the source collection,
     * choosing the correct answer and another two false
     * */
    public QuizQuestion getNextQuestion(String quizName) {

        currentQuestionIndex++;

        // Load from repository only once
        if (questionsFromRepo == null){
            questionsFromRepo = repository.loadQuestions(quizName);
            if (questionsFromRepo == null)
                return null;
        }

        if (currentQuestionIndex < 5) {

            Collections.shuffle(questionsFromRepo, new Random());

            Question chosenQuestion = questionsFromRepo.get(0);

            List<String> possibleAnswers = new ArrayList<String>();
            possibleAnswers.add(chosenQuestion.getAnswer());
            possibleAnswers.add(questionsFromRepo.get(1).getAnswer());
            possibleAnswers.add(questionsFromRepo.get(2).getAnswer());
            Collections.shuffle(possibleAnswers);

            return new QuizQuestion(chosenQuestion, possibleAnswers);
        } else{
            questionsFromRepo = null;
            return null;
        }
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
