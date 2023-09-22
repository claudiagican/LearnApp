package com.learn;

import com.learn.model.QuizQuestion;
import com.learn.repository.VerbsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private VerbsRepositoryImpl verbsRepositoryImpl;

    private QuizQuestion quizQuestion;

    @GetMapping("/quiz")
    public String showQuizQuestion(Model model)
    {
        quizQuestion = verbsRepositoryImpl.loadRandomQuestion();
        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", "");
        return "quiz";
    }

    @PostMapping("/quizSubmit")
    public String validateQuizQuestion(@RequestParam("selectedAnswer") String selectedAnswer, Model model)
    {

        boolean isCorrect = checkAnswer(quizQuestion, selectedAnswer);
        String resultMessage = isCorrect ? "Correct!" : "Incorrect";

        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("result", "to sleep");
        return "quiz";
    }

    private boolean checkAnswer(QuizQuestion currentQuestion, String selectedAnswer) {
        return true;
    }
}
