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
import com.org.kapil.modal.Hotel;
import com.org.kapil.repository.HotelRepository;


@RestController
@RequestMapping("/api/v1")
public class HotelController {
	@Autowired
	private HotelRepository hotelRepository;

	@GetMapping("/hotels")
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(value = "id") Long hotelId)
			throws ResourceNotFoundException {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelId));
		return ResponseEntity.ok().body(hotel);
	}

	@PostMapping("/hotels")
	public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@PutMapping("/hotels/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") Long hotelId,
			@Valid @RequestBody Hotel hotelDetails) throws ResourceNotFoundException {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelId));

		
		hotel.setFoods(hotelDetails.getFoods());
		hotel.setName(hotelDetails.getName());
		hotel.setLocation(hotelDetails.getName());
		Hotel updatedHotel = hotelRepository.save(hotel);
		return ResponseEntity.ok(updatedHotel);
	}

	@DeleteMapping("/hotels/{id}")
	public Map<String, Boolean> deleteHotel(@PathVariable(value = "id") Long hotelId)
			throws ResourceNotFoundException {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for this id :: " + hotelId));

		hotelRepository.delete(hotel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}