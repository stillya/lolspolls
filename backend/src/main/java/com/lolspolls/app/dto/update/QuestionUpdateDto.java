package com.lolspolls.app.dto.update;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionUpdateDto {

    private UUID id;
    private UUID pollId;
    private String name;
    private String hint;
    private String type;

}
