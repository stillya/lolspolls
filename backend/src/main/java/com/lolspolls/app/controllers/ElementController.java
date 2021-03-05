package com.lolspolls.app.controllers;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.dto.create.ElementCreateDto;
import com.lolspolls.app.dto.read.ElementDto;
import com.lolspolls.app.dto.update.ElementUpdateDto;
import com.lolspolls.app.services.crud.ElementsCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/element")
@RequiredArgsConstructor
public class ElementController {

    private final ElementsCrudService elementsCrudService;

    //
    // API
    //

    @GetMapping(path = "/{elementId}")
    public List<ElementDto> getElementsById(@PathVariable("elementId") UUID elementId) {
        return this.elementsCrudService.getElementsById(elementId);
    }

    @PostMapping
    public ElementDto createElement(ElementCreateDto element) {
        return this.elementsCrudService.createElement(element);
    }

    @PutMapping(path = "/update")
    public ElementDto updateElement(ElementUpdateDto element) {
        return this.elementsCrudService.updateElement(element);
    }

}
