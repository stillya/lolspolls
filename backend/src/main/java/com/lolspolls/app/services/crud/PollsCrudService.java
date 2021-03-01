package com.lolspolls.app.services.crud;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import com.lolspolls.app.dto.create.PollCreateDto;
import com.lolspolls.app.dto.read.PollDto;
import com.lolspolls.app.dto.update.PollUpdateDto;
import com.lolspolls.app.entities.PollEntity;
import com.lolspolls.app.entities.UserEntity;
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
    private final UsersCrudService usersCrudService;

    //
    // API
    //

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
    public PollDto createPoll(PollCreateDto poll) {
        log.debug("CREATE POLL");
        UserEntity user = Converter.UserDtoToUserEntity(this.usersCrudService.findById(poll.getOwner()));
        PollEntity pollEntity = this.pollRepository.save(Converter.PollCreateDtoToPollEntity(poll, user));
        return Converter.PollEntityToPollDto(pollEntity);
    }

    @Transactional
    public PollDto updatePoll(PollUpdateDto poll) {
        log.debug("CREATE POLL");
        return Converter.PollEntityToPollDto(this.pollRepository.save(Converter.PollUpdateDtoToPollEntity(poll)));
    }

}
