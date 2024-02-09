package com.lara.laraChallenge.dto.responseMessageBody;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class SimpleTextMessage implements IntResponseMessage {
    private String employeeId;
    private String body;
    private String webhookUrl;
    private Map<String, String> webhookContext;

}
