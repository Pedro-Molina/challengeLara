package com.lara.laraChallenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Entity
@Getter
@Setter
public class Conversation {

    //Se podria guardar con un id especifico
    private final IntQuestion lastQuestion = new FinalGreeting(0L,"Gracias por contestar todas las preguntas. ¡Hablamos pronto!\n");
    private Integer nextQuestionIndex = 0;
    private Integer totalQuestions;
    String employeeId;
    Long conversationId;
    public List<IntQuestion> questionsList;
    public List<Answer> answersList;
    public ConversationState state;

    public Conversation(String employeeId, Integer totalQuestions) {
        this.employeeId = employeeId;
        this.totalQuestions = totalQuestions;
    }
    public IntQuestion getNextQuestion(){
        return this.state.nextQuestion();
    }

    public void incremetNextQuestionIndex (){
        nextQuestionIndex++;
    }

    public IntQuestion getCurrentQuestion(){
        return this.getQuestionsList().get(nextQuestionIndex);
    }



}
