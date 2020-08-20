package com.org.kapil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.kapil.modal.Booking;
import com.org.kapil.modal.Food;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
