package com.learn.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.model.Question;
import com.learn.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JSONRepository implements IRepository{

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<String> listOfAvailableQuizzes() {
        return Arrays.asList("GermanVerbs", "Mountains");
    }

    @Override
    public List<Question> loadQuestions(String source) {
        return loadQuizFromJSON(source);
    }

    public List<Question> loadQuizFromJSON(String fileName){

        Questions quizSet;
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

            Resource resource = resourceLoader.getResource("classpath:data/" + fileName + ".json");

            quizSet = objectMapper.readValue(resource.getFile(), Questions.class);

            System.out.println(quizSet);
        } catch (Exception ex){
            System.out.println("Cannot find or read the file " + fileName + ". " + ex.getMessage());
            return null;
        }
        return quizSet.getQuestions();
    }
}
