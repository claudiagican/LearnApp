package com.learn;

import com.learn.model.QAndAModel;
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

    private QAndAModel currentQuestion;

    @GetMapping("/quiz")
    public String showQuizQuestion(Model model)
    {
        currentQuestion = verbsRepositoryImpl.loadRandomQuestions(3);
        model.addAttribute("quizQuestion", currentQuestion);
        model.addAttribute("result", "");
        return "quiz";
    }

    @PostMapping("/quizSubmit")
    public String validateQuizQuestion(@RequestParam("selectedAnswer") String selectedAnswer, Model model)
    {

        boolean isCorrect = checkAnswer(currentQuestion, selectedAnswer);
        String resultMessage = isCorrect ? "Correct!" : "Incorrect";

        model.addAttribute("quizQuestion", currentQuestion);
        model.addAttribute("result", "to sleep");
        return "quiz";
    }

    private boolean checkAnswer(QAndAModel currentQuestion, String selectedAnswer) {
        return true;
    }
}
