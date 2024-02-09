package com.lara.laraChallenge.controller;

import com.lara.laraChallenge.dto.InitConversationBody;
import com.lara.laraChallenge.dto.ResponseBody;
import com.lara.laraChallenge.dto.WebHook;
import com.lara.laraChallenge.dto.responseMessageBody.IntResponseMessage;
import com.lara.laraChallenge.entity.Conversation;
import com.lara.laraChallenge.service.AnswerService;
import com.lara.laraChallenge.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/conversation")
public class ConversationController {

    private final String targetUrl = "http://localhost:8080/v1/message"; // Replace with your target API URL
    @Autowired
    ConversationService conversationService;
    @Autowired
    AnswerService answerService;

    @PostMapping("/employee-answer")
    public ResponseEntity<String> receiveEmployeeAnswer(@RequestBody WebHook employeeAnswer) {

        String employeeId = employeeAnswer.getData().getEmployeeId();
        String answerRecived = employeeAnswer.getData().getAnswer();
        String conversationId = employeeAnswer.getData().getContext().get("conversationId");
        String answeredQuestionId = employeeAnswer.getData().getContext().get("questionId");

        //recuperar la conversacion
        Conversation conversation = conversationService.getConversationById(conversationId);
        //Guardo respuesta
        answerService.saveAnwser(answerRecived, conversationId, answeredQuestionId);
        //Envio siguiente pregunta
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String currentQuestionId = conversation.getCurrentQuestion().getQuestionId().toString();
        IntResponseMessage requestObject = conversationService.getNextQuestionConversationConversationById(conversation.getConversationId().toString()).getResquestBody(employeeId, conversationId, currentQuestionId);
        HttpEntity<IntResponseMessage> request = new HttpEntity<>(requestObject, headers);
        ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);

        //Response
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }

    @PostMapping("/create-conversation")
    public ResponseEntity<ResponseBody> createConversation(@RequestBody InitConversationBody initConversationBody) {

        ResponseBody sendResponseBody = new ResponseBody("");
        try {
            String employeeId = initConversationBody.getEmployeeId();
            //Creo la conversacion
            Conversation conversation = conversationService.createConversation(initConversationBody.getEmployeeId(), initConversationBody.getQuestionsId());

            //Enviar primera pregunta
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String currentQuestion = conversation.getCurrentQuestion().getQuestionId().toString();
            String conversationId = conversation.getConversationId().toString();
            IntResponseMessage requestObject = conversationService.getNextQuestionConversationConversationById(conversationId).getResquestBody(employeeId, conversationId, currentQuestion);
            HttpEntity<IntResponseMessage> request = new HttpEntity<>(requestObject, headers);
            ResponseEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);
            sendResponseBody.setMessage("Creacion de conversacion exitosa");

        } catch (Exception e) {
            // Manejar otras excepciones
            sendResponseBody.setMessage("Una de las preguntas enviadas no existe");

        }finally {
            //Response
            return new ResponseEntity<ResponseBody>(sendResponseBody, HttpStatus.OK);
        }
    }
}

