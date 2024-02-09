package com.lara.laraChallenge.repository;

import com.lara.laraChallenge.entity.Conversation;
import com.lara.laraChallenge.entity.IntQuestion;

import java.util.ArrayList;
import java.util.List;

public class ConversationRepository {
        private static ConversationRepository conversationRepositoryInstance;
        private List<Conversation> conversations;

        private Long nextConversationId;

        private ConversationRepository() {
            conversations = new ArrayList<>();
            nextConversationId = 0L;
        }

        public static ConversationRepository getInstance() {
            if (conversationRepositoryInstance == null) {
                conversationRepositoryInstance = new ConversationRepository();
            }
            return conversationRepositoryInstance;
        }

        public void addConversation(Conversation conversation) {
            conversation.setConversationId(nextConversationId++);
            conversations.add(conversation);
        }

        public List<Conversation> getAllConversations() {
            return conversations;
        }

        public IntQuestion getNextQuestionConversationByEmployeeId(String employeeId) {
            for (Conversation conversation : conversations) {
                if (conversation.getEmployeeId().equals(employeeId)) {
                    return conversation.getNextQuestion();
                }
            }
            return null; // Si no se encuentra ninguna conversación con el ID del empleado
        }
        public Conversation getConversationByEmployeeId(String employeeId) {
            for (Conversation conversation : conversations) {
                if (conversation.getEmployeeId().equals(employeeId)) {
                    return conversation;
                }
            }
            return null; // Si no se encuentra ninguna conversación con el ID del empleado
        }

        public Conversation getConversationById(String conversationId) {
            Long conversationIdLong = Long.valueOf(conversationId);
            for (Conversation conversation : conversations) {
                if (conversation.getConversationId().equals(conversationIdLong)) {
                    return conversation;
                }
            }
            return null;
        }

        public IntQuestion getNextQuestionConversationConversationById(String conversationId) {
            Long conversationIdLong = Long.valueOf(conversationId);
            for (Conversation conversation : conversations) {
                if (conversation.getConversationId().equals(conversationIdLong)) {
                    return conversation.getNextQuestion();
                }
            }
            return null;
        }
    }

