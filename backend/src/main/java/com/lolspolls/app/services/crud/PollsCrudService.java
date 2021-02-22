package com.lolspolls.app.services.crud;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.lolspolls.app.dto.PollDto;
import com.lolspolls.app.entities.PollEntity;
import com.lolspolls.app.repositories.PollRepository;
import com.lolspolls.app.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PollsCrudService {

    private final PollRepository pollRepository;

    public List<PollDto> getPolls() {
        log.debug("GET ALL POLLS");
        return this.pollRepository.findAll().stream().map(Converter::PollEntityToPollDto).collect(Collectors.toList());
    }

    public PollDto getPollById(UUID id) {
        log.debug("GET POLL BY ID" + id);
        return this.pollRepository.findById(id)
                .map(Converter::PollEntityToPollDto)
                .orElseThrow(() -> new RuntimeException("Poll not found by id = " + id));
    }

    @Transactional
    public PollDto createPoll(PollDto poll) {
        log.debug("CREATE POLL");
        return Converter.PollEntityToPollDto(this.pollRepository.save(Converter.PollDtoToPollEntity(poll)));
    }

    @Transactional
    public PollDto updatePoll(PollDto poll) {
        log.debug("CREATE POLL");
        return Converter.PollEntityToPollDto(this.pollRepository.save(Converter.PollDtoToPollEntity(poll)));
    }


}
