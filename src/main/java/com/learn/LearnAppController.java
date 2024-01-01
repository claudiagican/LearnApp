package com.learn;

import com.learn.model.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearnAppController {

    @Autowired
    private LearnAppService learnAppService;
    private QuizQuestion quizQuestion;

    @GetMapping("/index")
    public String showMainPage(Model model)
    {
        learnAppService.resetCurrentQuestionIndex();
        learnAppService.resetScore();
        model.addAttribute("availableQuizzes", learnAppService.listOfAvailableQuizzes());
        return "index";
    }

    @GetMapping("/quiz/{quizName}")
    public String showQuizQuestion(@PathVariable("quizName") String quizName,
                                   Model model)
    {
        System.out.println(quizName);
        quizQuestion = learnAppService.getNextQuestion(quizName);

        if(quizQuestion != null) {

            model.addAttribute("quizQuestion", quizQuestion);
            model.addAttribute("result", "");
            model.addAttribute("quizTitle", quizName);
            model.addAttribute("quizName", quizName);
            model.addAttribute("currentNumber", learnAppService.getCurrentQuestionIndex() + 1);

        } else{
            model.addAttribute("result", learnAppService.getScore());
            model.addAttribute("currentNumber", learnAppService.getCurrentQuestionIndex());
        }
        return "quiz";
    }

    @PostMapping("/quiz/{quizName}")
    public String validateQuizQuestion(@RequestParam("answerOption") String selectedAnswer,
                                       @PathVariable("quizName") String quizName,
                                       Model model)
    {
        model.addAttribute("quizTitle", quizName);
        model.addAttribute("quizName", quizName);
        model.addAttribute("currentNumber", learnAppService.getCurrentQuestionIndex() + 1);

        learnAppService.checkAnswer(quizQuestion.getQuestion(), selectedAnswer);
        String result = quizQuestion.getQuestion().getAnswer();

        model.addAttribute("quizQuestion", quizQuestion);
        model.addAttribute("initialAnswer", selectedAnswer);
        model.addAttribute("result", result);
        return "quiz";
    }

}
