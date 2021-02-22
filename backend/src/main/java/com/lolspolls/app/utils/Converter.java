package com.lolspolls.app.utils;

import java.util.stream.Collectors;

import com.lolspolls.app.dto.ElementDto;
import com.lolspolls.app.dto.PollDto;
import com.lolspolls.app.dto.QuestionDto;
import com.lolspolls.app.dto.UserDto;
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
                .questions(poll.getQuestions()
                        .stream()
                        .map(Converter::QuestionEntityToQuestionDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private static UserDto UserEntityToUserDto(UserEntity user) {
        return UserDto.builder().id(user.getId()).name(user.getName()).username(user.getUsername()).build();
    }

    private static QuestionDto QuestionEntityToQuestionDto(QuestionEntity question) {
        return QuestionDto.builder()
                .id(question.getId())
                .pollId(question.getPollId())
                .hint(question.getHint())
                .name(question.getName())
                .type(question.getType())
                .elements(question.getElements()
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

    public static PollEntity PollDtoToPollEntity(PollDto poll) {
        return PollEntity.builder()
                .author(Converter.UserDtoToUserEntity(poll.getOwner()))
                .date(poll.getDate())
                .description(poll.getDescription())
                .id(poll.getId())
                .name(poll.getName())
                .build();
    }

    public static UserEntity UserDtoToUserEntity(UserDto user) {
        return UserEntity.builder().id(user.getId()).name(user.getName()).username(user.getUsername()).build();
    }

    public static QuestionEntity QuestionDtoToQuestionEntity(QuestionDto question) {
        return QuestionEntity.builder().id(question.getId()).hint(question.getHint()).pollId(question.getPollId()).build();
    }

    public static ElementEntity ElementDtoToElementEntity(ElementDto element) {
        return ElementEntity.builder()
                .id(element.getId())
                .questionId(element.getQuestionId())
                .required(element.isRequired())
                .value(element.getValue())
                .build();
    }

}