package com.el.wimp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.el.wimp.models.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long>{
//	List<Award> findByTitle(String title);
	
}
