package com.lara.laraChallenge.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ConversationState {

    private Conversation conversation;
    public ConversationState(Conversation conversation){
        this.conversation = conversation;
    }

    public abstract IntQuestion nextQuestion();
}
