package com.el.wimp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.el.wimp.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findByLastNameIgnoringCase(String lastname);

}
