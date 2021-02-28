package com.lolspolls.app.dto.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollCreateDto {

    private String name;
    private String description;
    private UUID owner;

}
