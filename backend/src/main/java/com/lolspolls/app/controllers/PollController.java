package com.lolspolls.app.controllers;

import com.lolspolls.app.dto.PollDto;
import com.lolspolls.app.services.crud.PollsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollsCrudService pollsCrudService;

    @PostMapping
    public void createPoll(@RequestBody PollDto poll) {
        this.pollsCrudService.createPoll(poll);
    }

}
