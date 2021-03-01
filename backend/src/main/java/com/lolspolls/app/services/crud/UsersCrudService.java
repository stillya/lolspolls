package com.lolspolls.app.services.crud;

import java.util.UUID;

import com.lolspolls.app.dto.read.UserDto;
import com.lolspolls.app.repositories.UserRepository;
import com.lolspolls.app.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersCrudService {

    private final UserRepository userRepository;

    //
    // API
    //

    public UserDto findById(UUID id) {
        return this.userRepository.findById(id).map(Converter::UserEntityToUserDto).
                orElseThrow(() -> new RuntimeException("User not found by id = " + id));
    }

}
