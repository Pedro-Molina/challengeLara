package com.lara.laraChallenge.entity;


import com.lara.laraChallenge.dto.responseMessageBody.IntResponseMessage;

public interface IntQuestion {
    public String getQuestion();
    public void setQuestion(String question);
    public Long getQuestionId();
    public IntResponseMessage getResquestBody(String employeeId, String conversationId, String questionId);
}
