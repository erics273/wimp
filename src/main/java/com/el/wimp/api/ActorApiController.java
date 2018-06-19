package com.el.wimp.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.el.wimp.models.Actor;
import com.el.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorApiController {

	private ActorRepository actorRepository;

	public ActorApiController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@GetMapping("")
	public List<Actor> getAll(){
		List<Actor> actors = actorRepository.findAll();
		return actors;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@RequestBody Actor actor) {
		return actorRepository.save(actor);

	}

	@GetMapping("{id}")
	public Actor getOne(@PathVariable Long id) {
		return actorRepository.findOne(id);

	}

	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		return actorRepository.save(actor);

	}

	@DeleteMapping("{id}")
	public Actor delete(@PathVariable Long id) {
		// Get the actor from the "database" so I can return later
		Actor actor = actorRepository.findOne(id);
		// Delete the actor from the database (in this case just set the
		// value in the array list to null).
		actorRepository.delete(id);
		// Return the actor I just deleted.
		return actor;
	}
}
