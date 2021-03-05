package com.lolspolls.app.services.crud;

import java.util.List;
import java.util.stream.Collectors;

import com.lolspolls.app.dto.create.PollResultCreateDto;
import com.lolspolls.app.dto.read.PollResultDto;
import com.lolspolls.app.repositories.PollResultRepository;
import com.lolspolls.app.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PollResultsCrudService {

    private final PollResultRepository pollResultRepository;

    //
    // API
    //

    public PollResultDto createPollResult(PollResultCreateDto pollResult) {
        return Converter.PollResultEntityToPollResultToDto(this.pollResultRepository.save(Converter.PollResultCreateDtoToPollResultEntity(
                pollResult)));
    }

    public List<PollResultDto> getPollResults() {
        return this.pollResultRepository.findAll()
                .stream()
                .map(Converter::PollResultEntityToPollResultToDto)
                .collect(Collectors.toList());
    }

}
