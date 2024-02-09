package com.lara.laraChallenge.dto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextWebHookBody.class, name = "text"),
        @JsonSubTypes.Type(value = ButtonSelectedWebhookBody.class, name = "button")
})
public interface WebHookBody {

        String getType();
        String getEmployeeId();
        Map<String, String> getContext();
        String getAnswer();

}

