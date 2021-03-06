package com.lolspolls.app.dto.update;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementUpdateDto {

    private UUID id;
    private UUID questionId;
    private String value;
    private Boolean required;

}
