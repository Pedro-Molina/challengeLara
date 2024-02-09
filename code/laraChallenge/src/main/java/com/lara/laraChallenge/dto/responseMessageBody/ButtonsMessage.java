package com.lara.laraChallenge.dto.responseMessageBody;

import com.lara.laraChallenge.entity.OptionButton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ButtonsMessage implements IntResponseMessage {
    private String employeeId;
    private String body;
    private String webhookUrl;
    private List<OptionButton> buttons;
    private Map<String, String> webhookContext;

}
