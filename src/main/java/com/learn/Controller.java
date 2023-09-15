package com.learn;

import com.learn.model.QAndAModel;
import com.learn.repository.VerbsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private VerbsRepositoryImpl verbsRepositoryImpl;

    @GetMapping("/")
    public String loadHomePage(Model model)
    {
        QAndAModel question = verbsRepositoryImpl.loadRandomQuestions(3);
        model.addAttribute("question", question);
        return "index";
    }

}
