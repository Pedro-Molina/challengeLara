package com.lara.laraChallenge.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


public class TextWebHookBody implements WebHookBody {
    private String type;
    private String employeeId;
    @JsonProperty("text")
    private String text;
    private Map<String, String> context;

    public String getType() {
        return type;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getAnswer() {
        return text;
    }

    public Map<String, String> getContext() {
        return context;
    }
}
