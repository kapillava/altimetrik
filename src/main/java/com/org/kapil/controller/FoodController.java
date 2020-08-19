package com.org.kapil.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.kapil.exception.ResourceNotFoundException;
import com.org.kapil.modal.Food;
import com.org.kapil.repository.FoodRepository;


@RestController
@RequestMapping("/api/v1")
public class FoodController {
	@Autowired
	private FoodRepository foodRepository;

	@GetMapping("/foods")
	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}

	@GetMapping("/foods/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") Long foodId)
			throws ResourceNotFoundException {
		Food food = foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id :: " + foodId));
		return ResponseEntity.ok().body(food);
	}

	@PostMapping("/foods")
	public Food createFood(@Valid @RequestBody Food food) {
		return foodRepository.save(food);
	}

	@PutMapping("/foods/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable(value = "id") Long foodId,
			@Valid @RequestBody Food foodDetails) throws ResourceNotFoundException {
		Food food = foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id :: " + foodId));

		
		food.setHotel(foodDetails.getHotel());
		food.setName(foodDetails.getName());
		food.setPrice(foodDetails.getPrice());
		food.setQuantity(foodDetails.getQuantity());
		Food updatedFood = foodRepository.save(food);
		return ResponseEntity.ok(updatedFood);
	}

	@DeleteMapping("/foods/{id}")
	public Map<String, Boolean> deleteFood(@PathVariable(value = "id") Long foodId)
			throws ResourceNotFoundException {
		Food food = foodRepository.findById(foodId)
				.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id :: " + foodId));

		foodRepository.delete(food);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
