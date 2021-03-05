package com.lolspolls.app.controllers;

import java.util.List;

import com.lolspolls.app.dto.create.PollResultCreateDto;
import com.lolspolls.app.dto.read.PollResultDto;
import com.lolspolls.app.services.crud.PollResultsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class PollResultController {

    private final PollResultsCrudService pollResultsCrudService;

    //
    // API
    //

    @GetMapping
    public List<PollResultDto> getResults() {
        return this.pollResultsCrudService.getPollResults();
    }

    @PostMapping
    public PollResultDto createResult(@RequestBody PollResultCreateDto result) {
        return this.pollResultsCrudService.createPollResult(result);
    }

}
