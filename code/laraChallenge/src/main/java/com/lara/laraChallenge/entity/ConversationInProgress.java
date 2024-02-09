package com.lara.laraChallenge.entity;

public class ConversationInProgress extends ConversationState{
    ConversationInProgress(Conversation conversation){
        super(conversation);
    }
    @Override
    public IntQuestion nextQuestion() {
        getConversation().incremetNextQuestionIndex();
        if (getConversation().getNextQuestionIndex() >= getConversation().getTotalQuestions()){
            getConversation().setState(new ConversationFinished(getConversation()));
        }
        return getConversation().getCurrentQuestion();
    }
}
