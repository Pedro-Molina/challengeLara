package com.lara.laraChallenge.entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Answer {
    Long answerId;
    Long conversationId;
    Long questionId;
    String answer;
}
