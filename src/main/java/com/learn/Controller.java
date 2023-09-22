package com.learn;

import com.learn.model.QuizQuestion;
import com.learn.repository.InMemoryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;
    private QuizQuestion quizQuestion;

    @GetMapping("/quiz")
    public String showQuizQuestion(Model model)
    {
        quizQuestion = service.getNextQuestion();
        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", "");
        return "quiz";
    }

    @PostMapping("/quizSubmit")
    public String validateQuizQuestion(@RequestParam("selectedAnswer") String selectedAnswer, Model model)
    {

        boolean isCorrect = service.checkAnswer(quizQuestion.getQuestion(), selectedAnswer);
        String resultMessage = isCorrect ? "Correct!" : "Incorrect";

        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", resultMessage);
        return "quiz";
    }

}
