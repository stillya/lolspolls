package com.lolspolls.app.repositories;

import java.util.UUID;

import com.lolspolls.app.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, UUID> {

}
