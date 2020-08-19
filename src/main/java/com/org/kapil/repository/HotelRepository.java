package com.org.kapil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.kapil.modal.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
