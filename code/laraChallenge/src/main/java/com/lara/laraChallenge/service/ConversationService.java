package com.lara.laraChallenge.service;

import com.lara.laraChallenge.entity.Conversation;
import com.lara.laraChallenge.entity.ConversationInitilized;
import com.lara.laraChallenge.entity.IntQuestion;
import com.lara.laraChallenge.repository.ConversationRepository;
import com.lara.laraChallenge.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    public Conversation createConversation(String employeeId, List<Long> questionsId) throws Exception{
        //Creo nueva conver
        Conversation conversation = new Conversation(employeeId, questionsId.size()-1);

        //Seteo las preguntas de la conver
        conversation.setQuestionsList(QuestionRepository.getInstance().selectConversationQuestions(questionsId));

        //manejar el error si no se encuentran las preguntas

        //Inicializo el estado de la conver
        conversation.setState(new ConversationInitilized(conversation));

        //Persisto la conversation
        ConversationRepository.getInstance().addConversation(conversation);

        return conversation;
    }

    public IntQuestion getNextQuestionConversationByEmployeeId(String employeeId){
        return ConversationRepository.getInstance().getNextQuestionConversationByEmployeeId(employeeId);
    }

    public Conversation getConversationByEmployeeId(String employeeId){
        return ConversationRepository.getInstance().getConversationByEmployeeId(employeeId);
    }

    public Conversation getConversationById(String conversationId){
        return ConversationRepository.getInstance().getConversationById(conversationId);
    }

    public IntQuestion getNextQuestionConversationConversationById(String conversationId) {
        return ConversationRepository.getInstance().getNextQuestionConversationConversationById(conversationId);
    }




}
