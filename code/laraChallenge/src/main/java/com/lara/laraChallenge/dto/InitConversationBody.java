package com.lara.laraChallenge.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class InitConversationBody {
    private String employeeId;
    private List<Long> questionsId;

}
