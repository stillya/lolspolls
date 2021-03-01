package com.lolspolls.app.dto.read;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.dto.types.ElementTypeEnum;
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
    private List<ElementDto> elements;

}
