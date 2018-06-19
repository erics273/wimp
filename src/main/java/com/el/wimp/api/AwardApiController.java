package com.el.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.wimp.models.Actor;
import com.el.wimp.models.Award;
import com.el.wimp.repositories.ActorRepository;
import com.el.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardApiController {

	private ActorRepository actorRepository;
	private AwardRepository awardRepository;

	public AwardApiController(ActorRepository actorRepository, AwardRepository awardRepository) {
		this.actorRepository = actorRepository;
		this.awardRepository = awardRepository;

	}

	@PostMapping("")
	public Award create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = actorRepository.findOne(actorId); // get an actor
		award.setActor(actor); // assign the award to the actor
		awardRepository.save(award);
		return award; // see the actor with the award associated

	}
}
