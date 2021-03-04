package com.lolspolls.app.dto.create;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionCreateDto {

    private UUID pollId;
    private String name;
    private String hint;
    private String type;

}
