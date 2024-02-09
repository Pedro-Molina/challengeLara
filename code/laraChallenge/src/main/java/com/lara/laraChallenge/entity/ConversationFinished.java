package com.lara.laraChallenge.entity;

public class ConversationFinished extends ConversationState {
    ConversationFinished(Conversation conversation){
        super(conversation);
    }
    @Override
    public IntQuestion nextQuestion() {
        return getConversation().getLastQuestion();
    }
}
