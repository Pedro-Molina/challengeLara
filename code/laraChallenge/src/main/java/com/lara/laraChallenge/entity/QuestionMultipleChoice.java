package com.lara.laraChallenge.entity;

import com.lara.laraChallenge.dto.responseMessageBody.ButtonsMessage;
import com.lara.laraChallenge.dto.responseMessageBody.IntResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
//@Entity
public class QuestionMultipleChoice implements IntQuestion {
    Long questionId;
    String question;
    List<OptionButton> options;

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public IntResponseMessage getResquestBody(String employeeId, String conversationId, String questionId) {
        Map<String,String> context = new HashMap<>();
        context.put("conversationId", conversationId);
        context.put("questionId", questionId);
        return new ButtonsMessage(employeeId, question, "http://host.docker.internal:8081/conversation/employee-answer",options,context);
    }


}
