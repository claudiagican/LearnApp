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

    @GetMapping("/index")
    public String showMainPage(Model model)
    {
        service.resetCurrentQuestionIndex();
        return "index";
    }

    @GetMapping("/quiz")
    public String showQuizQuestion(Model model)
    {
        quizQuestion = service.getNextQuestion();
        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", "");
        model.addAttribute("quizTitle", "German Verbs");
        model.addAttribute("currentNumber", service.getCurrentQuestionIndex());
        return "quiz";
    }

    @PostMapping("/quiz")
    public String validateQuizQuestion(@RequestParam("selectedAnswer") String selectedAnswer, Model model)
    {
        model.addAttribute("quizTitle", "German Verbs");
        model.addAttribute("currentNumber", service.getCurrentQuestionIndex());

        boolean isCorrect = service.checkAnswer(quizQuestion.getQuestion(), selectedAnswer);
        String resultMessage = isCorrect ? "Correct!" : "Incorrect";

        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", resultMessage);
        return "quiz";
    }

}
