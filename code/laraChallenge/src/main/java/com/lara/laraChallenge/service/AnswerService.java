package com.lara.laraChallenge.service;

import com.lara.laraChallenge.entity.Answer;
import com.lara.laraChallenge.repository.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    public Answer saveAnwser(String answer, String conversationId, String questionId ){
        return AnswerRepository.getInstance().saveAnwser(answer, Long.valueOf(conversationId), Long.valueOf(questionId));
    }

}
