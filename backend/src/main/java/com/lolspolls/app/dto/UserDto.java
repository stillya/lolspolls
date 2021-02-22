package com.lolspolls.app.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private UUID id;
    private String username;
    private String name;

}
