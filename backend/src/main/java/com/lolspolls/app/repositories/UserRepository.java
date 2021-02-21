package com.lolspolls.app.repositories;

import java.util.UUID;

import com.lolspolls.app.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

}
