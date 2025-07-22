package com.fjpp.dogs_in_shows.service;

import com.fjpp.dogs_in_shows.model.Dog;
import com.fjpp.dogs_in_shows.model.User;
import com.fjpp.dogs_in_shows.repository.DogRepository;
import com.fjpp.dogs_in_shows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    public DogService(DogRepository dogRepository, UserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
    }

    public Dog saveDog(Dog dog, Long ownerId) {
        User owner = userRepository.findById(ownerId).orElse(null);
        dog.setOwner(owner);
        return dogRepository.save(dog);
    }

    public List<Dog> findByUser(Long userId) {
        return dogRepository.findByOwnerId(userId);
    }

    public Optional<Dog> findById(Long id) {
        return dogRepository.findById(id);
    }
}
