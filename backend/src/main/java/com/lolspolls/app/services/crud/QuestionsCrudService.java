package com.lolspolls.app.services.crud;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lolspolls.app.dto.create.QuestionCreateDto;
import com.lolspolls.app.dto.read.QuestionDto;
import com.lolspolls.app.repositories.QuestionRepository;
import com.lolspolls.app.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionsCrudService {

    private final QuestionRepository questionRepository;

    //
    // API
    //

    public List<QuestionDto> getQuestions(@PathVariable UUID pollId) {
        log.debug("GET ALL QUESTIONS BY " + pollId);
        return this.questionRepository.findByPollId(pollId)
                .stream()
                .map(Converter::QuestionEntityToQuestionDto)
                .collect(Collectors.toList());
    }

    public QuestionDto createQuestion(@RequestBody QuestionCreateDto question) {
        log.debug("CREATE QUESTION BY " + question.getPollId());
        return Converter.QuestionEntityToQuestionDto(this.questionRepository.save(Converter.QuestionCreateDtoToQuestionEntity(
                question)));
    }

}
