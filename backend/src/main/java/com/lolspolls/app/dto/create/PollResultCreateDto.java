package com.lolspolls.app.dto.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollResultCreateDto {

    private UUID pollId;
    private String content;

}
