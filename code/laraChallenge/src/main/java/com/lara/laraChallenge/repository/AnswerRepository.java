package com.lara.laraChallenge.repository;

import com.lara.laraChallenge.entity.Answer;
import com.lara.laraChallenge.entity.IntQuestion;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository {
    private List<Answer> answers;
    private Long nextAnswerId;

    private static AnswerRepository answerRepositoryInstance = null;

    private AnswerRepository() {
        answers = new ArrayList<>();
        nextAnswerId = 0L;
    }
    public static AnswerRepository getInstance() {
        if (answerRepositoryInstance == null) {
            answerRepositoryInstance = new AnswerRepository();
        }
        return answerRepositoryInstance;
    }
    public Answer saveAnwser(String answer, Long conversationId, Long questionId ){
        Answer saveAnswer = new Answer(nextAnswerId, conversationId, questionId, answer);
        answers.add(saveAnswer);
        nextAnswerId++;
        return saveAnswer;
    }
}
