package com.lolspolls.app.repositories;

import java.util.List;
import java.util.UUID;

import com.lolspolls.app.entities.PollEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<PollEntity, UUID> {

    List<PollEntity> findAll();

    PollEntity save(PollEntity poll);

}
