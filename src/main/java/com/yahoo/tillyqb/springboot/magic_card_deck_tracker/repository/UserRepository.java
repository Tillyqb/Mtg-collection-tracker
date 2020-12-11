package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.repository;

import com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>
{
}