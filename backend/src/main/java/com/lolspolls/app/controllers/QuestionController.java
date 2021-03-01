package com.lolspolls.app.controllers;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.dto.create.QuestionCreateDto;
import com.lolspolls.app.dto.read.QuestionDto;
import com.lolspolls.app.services.crud.QuestionsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionsCrudService questionsCrudService;

    //
    // API
    //

    @PostMapping
    public QuestionDto createQuestion(@RequestBody QuestionCreateDto question) {
        return this.questionsCrudService.createQuestion(question);
    }

    @GetMapping(path = "/{pollId}")
    public List<QuestionDto> getQuestions(@PathVariable("pollId") UUID pollId) {
        return this.questionsCrudService.getQuestions(pollId);
    }
}
