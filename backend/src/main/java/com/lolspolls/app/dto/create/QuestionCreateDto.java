package com.lolspolls.app.dto.create;

import java.util.UUID;

import com.lolspolls.app.dto.types.ElementTypeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionCreateDto {

    private UUID pollId;
    private String name;
    private String hint;
    private ElementTypeEnum type;

}
