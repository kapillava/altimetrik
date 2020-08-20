package com.org.kapil.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.kapil.exception.ResourceNotFoundException;
import com.org.kapil.modal.Booking;
import com.org.kapil.repository.BookingRepository;


@RestController
@RequestMapping("/api/v1")
public class BookingController {
	@Autowired
	private BookingRepository bookingRepository;

	@GetMapping("/bookings")
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@GetMapping("/bookings/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable(value = "id") Long bookingId)
			throws ResourceNotFoundException {
		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bookingId));
		return ResponseEntity.ok().body(booking);
	}

	@PostMapping("/bookings")
	public Booking createBooking(@Valid @RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}

	@PutMapping("/bookings/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") Long bookingId,
			@Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bookingId));

		
		booking.setStatus(bookingDetails.getStatus());
		Booking updatedBooking = bookingRepository.save(booking);
		return ResponseEntity.ok(updatedBooking);
	}

}