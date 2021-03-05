package com.lolspolls.app.repositories;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.entities.PollResultEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollResultRepository extends CrudRepository<PollResultEntity, UUID> {

    List<PollResultEntity> findAll();



}
