package com.lolspolls.app.controllers;

import com.lolspolls.app.services.crud.PollResultsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/element")
@RequiredArgsConstructor
public class PollResultController {

    private final PollResultsCrudService pollResultsCrudService;

}
