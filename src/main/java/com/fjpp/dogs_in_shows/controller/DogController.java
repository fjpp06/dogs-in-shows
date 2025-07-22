package com.fjpp.dogs_in_shows.controller;

import com.fjpp.dogs_in_shows.model.Dog;
import com.fjpp.dogs_in_shows.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Dog> createDog(@PathVariable Long userId, @RequestBody Dog dog) {
        return ResponseEntity.ok(dogService.saveDog(dog, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Dog>> getDogs(@PathVariable Long userId) {
        return ResponseEntity.ok(dogService.findByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable Long id) {
        return dogService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
