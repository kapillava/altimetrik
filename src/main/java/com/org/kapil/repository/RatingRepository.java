package com.org.kapil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.kapil.modal.Food;
import com.org.kapil.modal.Rating;
import com.org.kapil.modal.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}
