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
        service.resetScore();
        return "index";
    }

    @GetMapping("/quiz")
    public String showQuizQuestion(Model model)
    {
        quizQuestion = service.getNextQuestion();

        if(quizQuestion != null) {

            model.addAttribute("quizQuestion", quizQuestion);
            model.addAttribute("result", "");
            model.addAttribute("quizTitle", "German Verbs");
            model.addAttribute("currentNumber", service.getCurrentQuestionIndex() + 1);

        } else{
            model.addAttribute("result", service.getScore());
            model.addAttribute("currentNumber", service.getCurrentQuestionIndex());
        }
        return "quiz";
    }

    @PostMapping("/quiz")
    public String validateQuizQuestion(@RequestParam("answearOption") String selectedAnswer, Model model)
    {
        model.addAttribute("quizTitle", "German Verbs");
        model.addAttribute("currentNumber", service.getCurrentQuestionIndex() + 1);

        service.checkAnswer(quizQuestion.getQuestion(), selectedAnswer);
        String result = quizQuestion.getQuestion().getAnswer();

        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("initialAnswer", selectedAnswer);
        model.addAttribute("result", result);
        return "quiz";
    }

}
