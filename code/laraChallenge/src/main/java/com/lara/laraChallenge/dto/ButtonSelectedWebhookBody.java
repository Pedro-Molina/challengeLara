package com.lara.laraChallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ButtonSelectedWebhookBody implements WebHookBody {
    private String type;
    private String employeeId;
    @JsonProperty("value")
    private String value;
    private Map<String, String> context;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getEmployeeId() {
        return this.employeeId;
    }

    @Override
    public Map<String, String> getContext() {
        return this.context;
    }

    @Override
    public String getAnswer() {
        return this.value;
    }

}
