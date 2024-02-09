package com.lara.laraChallenge.entity;

import com.lara.laraChallenge.dto.responseMessageBody.IntResponseMessage;
import com.lara.laraChallenge.dto.responseMessageBody.SimpleTextMessage;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class FinalGreeting implements  IntQuestion{

    Long questionId;
    String question;
    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public Long getQuestionId() {
        return this.questionId;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public IntResponseMessage getResquestBody(String employeeId, String conversationId, String questionId) {
        Map<String,String> context = new HashMap<>();
        context.put("conversationId", conversationId);
        context.put("questionId", questionId);
        return new SimpleTextMessage(employeeId, question, "http://host.docker.internal:8081/conversation/employee-answer", context);
    }
}
