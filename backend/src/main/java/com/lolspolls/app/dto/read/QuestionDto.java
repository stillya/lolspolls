package com.lolspolls.app.dto.read;

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
    private ElementTypeEnum type;

}
