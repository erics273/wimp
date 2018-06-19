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

import com.el.wimp.models.Movie;
import com.el.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieApiController {

	private MovieRepository movieRepository;

	public MovieApiController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping("")
	public List<Movie> getAll(@RequestParam(required = false) Long budget) {
		// if (budget != null) {
		// public List<Movie> getAll() {
		// return movieRepository.findByBudgetIgnoringCase(budget);
		// }
		return movieRepository.findAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);

	}

	@GetMapping("{id}")
	public Movie getOne(@PathVariable Long id) {
		return movieRepository.findOne(id);

	}

	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable Long id) {
		movie.setId(id);
		return movieRepository.save(movie);

	}

	@DeleteMapping("{id}")
	public Movie delete(@PathVariable Long id) {
		// Get the dog from the "database" so I can return later
		Movie movie = movieRepository.findOne(id);
		// Delete the dog from the database (in this case just set the
		// value in the array list to null).
		movieRepository.delete(id);
		// Return the dog I just deleted.
		return movie;
	}
}
