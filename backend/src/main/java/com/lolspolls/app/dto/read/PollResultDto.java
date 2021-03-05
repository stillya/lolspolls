package com.lolspolls.app.dto.read;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollResultDto {

    private UUID id;
    private String content;
    private PollDto poll;

}
