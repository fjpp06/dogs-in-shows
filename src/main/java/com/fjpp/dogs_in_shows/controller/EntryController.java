package com.fjpp.dogs_in_shows.controller;

import com.fjpp.dogs_in_shows.model.Entry;
import com.fjpp.dogs_in_shows.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping
    public ResponseEntity<Entry> createEntry(@RequestParam Long userId, @RequestParam Long dogId, @RequestBody List<Long> showIds) {
        return ResponseEntity.ok(entryService.createEntry(userId, dogId, showIds));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Entry>> getEntryByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(entryService.findByUser(userId));
    }

    @GetMapping("/{dogId}")
    public ResponseEntity<List<Entry>> getEntryByDogId(@PathVariable Long dogId) {
        return ResponseEntity.ok(entryService.findByDog(dogId));
    }
}
