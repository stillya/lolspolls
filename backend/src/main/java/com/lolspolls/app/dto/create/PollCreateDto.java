package com.lolspolls.app.dto.create;

import java.util.List;

import com.lolspolls.app.dto.read.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollCreateDto {

    private String name;
    private String description;
    private UserDto owner;

}
