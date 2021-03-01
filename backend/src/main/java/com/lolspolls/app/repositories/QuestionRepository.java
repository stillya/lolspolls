package com.lolspolls.app.repositories;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.dto.read.QuestionDto;
import com.lolspolls.app.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, UUID> {

    List<QuestionEntity> findByPollId(UUID id);

}
