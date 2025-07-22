package com.fjpp.dogs_in_shows.service;

import com.fjpp.dogs_in_shows.model.Dog;
import com.fjpp.dogs_in_shows.model.Entry;
import com.fjpp.dogs_in_shows.model.Show;
import com.fjpp.dogs_in_shows.model.User;
import com.fjpp.dogs_in_shows.repository.DogRepository;
import com.fjpp.dogs_in_shows.repository.EntryRepository;
import com.fjpp.dogs_in_shows.repository.ShowRepository;
import com.fjpp.dogs_in_shows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    private final ShowRepository showRepository;
    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    public EntryService(EntryRepository entryRepository, ShowRepository showRepository, DogRepository dogRepository, UserRepository userRepository) {
        this.entryRepository = entryRepository;
        this.showRepository = showRepository;
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
    }

    public Entry createEntry(Long userId, Long dogId, List<Long> showIds) {
        User user = userRepository.findById(userId).orElse(null);
        Dog dog = dogRepository.findById(dogId).orElse(null);
        List<Show> shows = showRepository.findAllById(showIds);

        Entry entry = new Entry();
        entry.setDog(dog);
        entry.setUser(user);
        entry.setShows(shows);

        return entryRepository.save(entry);
    }

    public List<Entry> findByUser(Long userId) {
        return entryRepository.findByUserId(userId);
    }

    public List<Entry> findByDog(Long dogId) {
        return entryRepository.findByDogId(dogId);
    }
}
