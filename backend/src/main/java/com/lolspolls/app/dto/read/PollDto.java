package com.lolspolls.app.dto.read;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollDto {

    private UUID id;
    private String name;
    private String description;
    private LocalDateTime date;
    private UserDto owner;
    private List<QuestionDto> questions;

}
