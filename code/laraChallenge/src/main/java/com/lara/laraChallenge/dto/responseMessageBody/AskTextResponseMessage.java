package com.lara.laraChallenge.dto.responseMessageBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AskTextResponseMessage implements IntResponseMessage {
    private String employeeId;
    private String body;
    private String webhookUrl;
    private boolean askText;
    private Map<String, String> webhookContext;

}
