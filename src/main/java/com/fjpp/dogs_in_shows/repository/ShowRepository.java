package com.fjpp.dogs_in_shows.repository;

import com.fjpp.dogs_in_shows.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByEventId(Long EventId);
}
