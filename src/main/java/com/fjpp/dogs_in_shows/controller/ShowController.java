package com.fjpp.dogs_in_shows.controller;

import com.fjpp.dogs_in_shows.model.Show;
import com.fjpp.dogs_in_shows.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Show> createShow(@PathVariable Long eventId, @RequestBody Show show) {
        return ResponseEntity.ok(showService.createShow(show, eventId));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Show>> getShowsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(showService.findByEvent(eventId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        return showService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
