package com.lolspolls.app.controllers;

import java.util.UUID;

import com.lolspolls.app.dto.create.PollCreateDto;
import com.lolspolls.app.dto.read.PollDto;
import com.lolspolls.app.dto.update.PollUpdateDto;
import com.lolspolls.app.services.crud.PollsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public PollDto createPoll(@RequestBody PollCreateDto poll) {
        return this.pollsCrudService.createPoll(poll);
    }

    @GetMapping(path = "/{pollId}")
    public PollDto getPollById(@PathVariable("pollId") UUID pollId) {
        return this.pollsCrudService.getPollById(pollId);
    }

    @PostMapping(path = "/update")
    public PollDto updatePoll(@RequestBody PollUpdateDto poll) {
        return this.pollsCrudService.updatePoll(poll);
    }

}
