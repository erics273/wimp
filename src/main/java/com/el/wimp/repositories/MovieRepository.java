package com.el.wimp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.el.wimp.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//	List<Movie> findByTitle(String title);
}
