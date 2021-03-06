package com.lolspolls.app.utils;

import java.util.HashSet;
import java.util.stream.Collectors;

import com.lolspolls.app.dto.create.ElementCreateDto;
import com.lolspolls.app.dto.create.PollCreateDto;
import com.lolspolls.app.dto.create.PollResultCreateDto;
import com.lolspolls.app.dto.create.QuestionCreateDto;
import com.lolspolls.app.dto.read.ElementDto;
import com.lolspolls.app.dto.read.PollDto;
import com.lolspolls.app.dto.read.PollResultDto;
import com.lolspolls.app.dto.read.QuestionDto;
import com.lolspolls.app.dto.read.UserDto;
import com.lolspolls.app.dto.update.ElementUpdateDto;
import com.lolspolls.app.dto.update.PollUpdateDto;
import com.lolspolls.app.dto.update.QuestionUpdateDto;
import com.lolspolls.app.entities.ElementEntity;
import com.lolspolls.app.entities.PollEntity;
import com.lolspolls.app.entities.PollResultEntity;
import com.lolspolls.app.entities.QuestionEntity;
import com.lolspolls.app.entities.UserEntity;

public class Converter {

    public static PollDto PollEntityToPollDto(PollEntity poll) {
        return PollDto.builder()
                .id(poll.getId())
                .date(poll.getDate())
                .name(poll.getName())
                .description(poll.getDescription())
                .owner(Converter.UserEntityToUserDto(poll.getAuthor()))
                .questions(poll.getQuestions() == null ? new HashSet<>() : poll.getQuestions()
                        .stream()
                        .map(Converter::QuestionEntityToQuestionDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static QuestionDto QuestionEntityToQuestionDto(QuestionEntity question) {
        return QuestionDto.builder()
                .id(question.getId())
                .pollId(question.getPollId())
                .hint(question.getHint())
                .name(question.getName())
                .type(question.getType())
                .elements(question.getElements() == null ? new HashSet<>() : question.getElements()
                        .stream()
                        .map(Converter::ElementEntityToElementDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static ElementDto ElementEntityToElementDto(ElementEntity element) {
        return ElementDto.builder()
                .id(element.getId())
                .questionId(element.getQuestionId())
                .required(element.isRequired())
                .value(element.getValue())
                .build();
    }

    public static PollEntity PollCreateDtoToPollEntity(PollCreateDto poll, UserEntity user) {
        return PollEntity.builder()
                .name(poll.getName())
                .description(poll.getDescription())
                .ownerId(poll.getOwner())
                .author(user)
                .build();
    }

    public static QuestionEntity QuestionCreateDtoToQuestionEntity(QuestionCreateDto question) {
        return QuestionEntity.builder()
                .pollId(question.getPollId())
                .name(question.getName())
                .hint(question.getHint())
                .type(question.getType())
                .build();
    }

    public static ElementEntity ElementCreateDtoToElementEntity(ElementCreateDto element) {
        return ElementEntity.builder()
                .questionId(element.getQuestionId())
                .value(element.getValue())
                .required(element.isRequired())
                .build();
    }

    public static PollEntity UpdatePollEntity(PollUpdateDto updatePoll, PollEntity poll) {
        if (updatePoll.getName() != null) {
            poll.setName(updatePoll.getName());
        }
        if (updatePoll.getDescription() != null) {
            poll.setDescription(updatePoll.getDescription());
        }
        return poll;
    }

    public static QuestionEntity UpdateQuestionEntity(QuestionUpdateDto updateQuestion, QuestionEntity question) {
        if (updateQuestion.getName() != null) {
            question.setName(updateQuestion.getName());
        }
        if (updateQuestion.getHint() != null) {
            question.setHint(updateQuestion.getHint());
        }
        if (updateQuestion.getType() != null) {
            question.setType(updateQuestion.getType());
        }
        return question;
    }

    public static ElementEntity UpdateElementEntity(ElementUpdateDto updateElement, ElementEntity element) {
        if (updateElement.getValue() != null) {
            element.setValue(updateElement.getValue());
        }
        if (updateElement.getRequired() != null) {
            element.setRequired(updateElement.getRequired());
        }
        return element;
    }

    public static UserDto UserEntityToUserDto(UserEntity user) {
        return UserDto.builder().id(user.getId()).username(user.getUsername()).name(user.getName()).build();
    }

    public static UserEntity UserDtoToUserEntity(UserDto user) {
        return UserEntity.builder().id(user.getId()).name(user.getName()).username(user.getUsername()).build();
    }

    public static PollResultEntity PollResultCreateDtoToPollResultEntity(PollResultCreateDto pollResult) {
        return PollResultEntity.builder().content(pollResult.getContent()).pollId(pollResult.getPollId()).build();
    }

    public static PollResultDto PollResultEntityToPollResultToDto(PollResultEntity pollResult) {
        return PollResultDto.builder()
                .id(pollResult.getId())
                .content(pollResult.getContent())
                .poll(Converter.PollEntityToPollDto(pollResult.getPoll()))
                .build();
    }

}
