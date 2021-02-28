package com.lolspolls.app.dto.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementCreateDto {

    private UUID questionId;
    private String value;
    private boolean required;

}
