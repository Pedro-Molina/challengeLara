package com.lara.laraChallenge.entity;

public class ConversationInitilized extends ConversationState {
    public ConversationInitilized(Conversation conversation){
        super(conversation);
    }
    @Override
    public IntQuestion nextQuestion(){
        getConversation().setState(new ConversationInProgress(getConversation()));
        return getConversation().getCurrentQuestion();
    }
}
