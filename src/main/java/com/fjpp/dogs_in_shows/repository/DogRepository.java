package com.fjpp.dogs_in_shows.repository;

import com.fjpp.dogs_in_shows.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByOwnerId(Long ownerId);

}
