package com.lolspolls.app.repositories;

import java.util.UUID;

import com.lolspolls.app.entities.ElementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends CrudRepository<ElementEntity, UUID> {

}
