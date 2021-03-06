package com.lolspolls.app.dto.update;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollUpdateDto {

    private UUID id;
    private String name;
    private String description;

}
