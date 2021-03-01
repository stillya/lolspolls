package com.lolspolls.app.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.lolspolls.app.dto.create.ElementCreateDto;
import com.lolspolls.app.dto.create.PollCreateDto;
import com.lolspolls.app.dto.create.QuestionCreateDto;
import com.lolspolls.app.dto.read.ElementDto;
import com.lolspolls.app.dto.read.PollDto;
import com.lolspolls.app.dto.read.QuestionDto;
import com.lolspolls.app.dto.read.UserDto;
import com.lolspolls.app.dto.update.ElementUpdateDto;
import com.lolspolls.app.dto.update.PollUpdateDto;
import com.lolspolls.app.dto.update.QuestionUpdateDto;
import com.lolspolls.app.entities.ElementEntity;
import com.lolspolls.app.entities.PollEntity;
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
                .questions(poll.getQuestions() == null ? new ArrayList<>() : poll.getQuestions()
                        .stream()
                        .map(Converter::QuestionEntityToQuestionDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private static QuestionDto QuestionEntityToQuestionDto(QuestionEntity question) {
        return QuestionDto.builder()
                .id(question.getId())
                .pollId(question.getPollId())
                .hint(question.getHint())
                .name(question.getName())
                .type(question.getType())
                .elements(question.getElements() == null ? new ArrayList<>() : question.getElements()
                        .stream()
                        .map(Converter::ElementEntityToElementDto)
                        .collect(Collectors.toList()))
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

    public static PollEntity PollUpdateDtoToPollEntity(PollUpdateDto poll) {
        return PollEntity.builder().id(poll.getId()).name(poll.getName()).description(poll.getDescription()).build();
    }

    public static QuestionEntity QuestionUpdateDtoToQuestionEntity(QuestionUpdateDto question) {
        return QuestionEntity.builder()
                .id(question.getId())
                .pollId(question.getPollId())
                .name(question.getName())
                .hint(question.getHint())
                .type(question.getType())
                .build();
    }

    public static ElementEntity ElementUpdateDtoToElementEntity(ElementUpdateDto element) {
        return ElementEntity.builder()
                .id(element.getId())
                .questionId(element.getQuestionId())
                .value(element.getValue())
                .required(element.isRequired())
                .build();
    }

    public static UserDto UserEntityToUserDto(UserEntity user) {
        return UserDto.builder().id(user.getId()).username(user.getUsername()).name(user.getName()).build();
    }

    public static UserEntity UserDtoToUserEntity(UserDto user) {
        return UserEntity.builder().id(user.getId()).name(user.getName()).username(user.getUsername()).build();
    }

}
