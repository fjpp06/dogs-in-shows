package com.fjpp.dogs_in_shows.repository;

import com.fjpp.dogs_in_shows.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByUserId(Long userId);
    List<Entry> findByDogId(Long dogId);
}
