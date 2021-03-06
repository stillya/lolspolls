package com.lolspolls.app.dto.read;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementDto {

    private UUID id;
    private UUID questionId;
    private String value;
    private boolean required;

}
