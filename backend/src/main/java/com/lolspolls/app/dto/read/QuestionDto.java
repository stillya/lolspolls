package com.lolspolls.app.dto.read;

import java.util.Set;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {

    private UUID id;
    private UUID pollId;
    private String name;
    private String hint;
    private String type;
    private Set<ElementDto> elements;

}
