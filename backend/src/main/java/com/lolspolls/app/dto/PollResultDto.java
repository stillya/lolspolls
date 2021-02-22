package com.lolspolls.app.dto;

import java.util.UUID;

import com.lolspolls.app.entities.PollEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollResultDto {

    private UUID id;
    private String content;
    private int responders;
    private PollEntity poll;

}
