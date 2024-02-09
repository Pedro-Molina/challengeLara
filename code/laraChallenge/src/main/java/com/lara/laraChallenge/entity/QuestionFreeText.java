package com.lara.laraChallenge.entity;

import com.lara.laraChallenge.dto.responseMessageBody.AskTextResponseMessage;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
//@Entity
public class QuestionFreeText implements IntQuestion {

    Long questionId;
    String question;

    public QuestionFreeText(Long id, String question) {
        this.questionId = id;
        this.question = question;
    }

    @Override
    public AskTextResponseMessage getResquestBody(String employeeId, String conversationId, String questionId) {
        Map<String,String> context = new HashMap<>();
        context.put("conversationId", conversationId);
        context.put("questionId", questionId);
        return new AskTextResponseMessage(employeeId, question,"http://host.docker.internal:8081/conversation/employee-answer",true,context);
    }
}

