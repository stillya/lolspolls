package com.lolspolls.app.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementDto {

    private UUID id;
    private String value;
    private boolean required;

}
