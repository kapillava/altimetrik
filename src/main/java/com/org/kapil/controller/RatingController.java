package com.org.kapil.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.kapil.exception.ResourceNotFoundException;
import com.org.kapil.modal.Rating;
import com.org.kapil.repository.RatingRepository;


@RestController
@RequestMapping("/api/v1")
public class RatingController {
	@Autowired
	private RatingRepository ratingRepository;

	@GetMapping("/ratings")
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@GetMapping("/ratings/{id}")
	public ResponseEntity<Rating> getRatingById(@PathVariable(value = "id") Long ratingId)
			throws ResourceNotFoundException {
		Rating rating = ratingRepository.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating not found for this id :: " + ratingId));
		return ResponseEntity.ok().body(rating);
	}

	@PostMapping("/ratings")
	public Rating createRating(@Valid @RequestBody Rating rating) {
		return ratingRepository.save(rating);
	}


}