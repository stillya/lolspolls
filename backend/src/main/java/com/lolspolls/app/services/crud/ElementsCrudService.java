package com.lolspolls.app.services.crud;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lolspolls.app.dto.create.ElementCreateDto;
import com.lolspolls.app.dto.read.ElementDto;
import com.lolspolls.app.dto.update.ElementUpdateDto;
import com.lolspolls.app.repositories.ElementRepository;
import com.lolspolls.app.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ElementsCrudService {

    private final ElementRepository elementRepository;

    //
    // API
    //

    public List<ElementDto> getElementsById(UUID id) {
        return this.elementRepository.findByQuestionId(id)
                .stream()
                .map(Converter::ElementEntityToElementDto)
                .collect(Collectors.toList());
    }

    public ElementDto createElement(ElementCreateDto element) {
        return Converter.ElementEntityToElementDto(this.elementRepository.save(Converter.ElementCreateDtoToElementEntity(
                element)));
    }

    public ElementDto updateElement(ElementUpdateDto elementUpdateDto) {
        return Converter.ElementEntityToElementDto(this.elementRepository.save(Converter.ElementUpdateDtoToElementEntity(
                elementUpdateDto)));
    }

}
