package com.learn.repository;

import com.learn.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IRepository {

    List<Question> loadRandomQuestion ();
}
