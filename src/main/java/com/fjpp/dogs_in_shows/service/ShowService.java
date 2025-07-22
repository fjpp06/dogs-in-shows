package com.fjpp.dogs_in_shows.service;

import com.fjpp.dogs_in_shows.model.Event;
import com.fjpp.dogs_in_shows.model.Show;
import com.fjpp.dogs_in_shows.repository.EventRepository;
import com.fjpp.dogs_in_shows.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final EventRepository eventRepository;

    public ShowService(ShowRepository showRepository, EventRepository eventRepository) {
        this.showRepository = showRepository;
        this.eventRepository = eventRepository;
    }

    public Show createShow(Show show, Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        show.setEvent(event);
        return showRepository.save(show);
    }

    public List<Show> findByEvent(Long eventId) {
        return showRepository.findByEventId(eventId);
    }

    public Optional<Show> findById(Long showId) {
        return showRepository.findById(showId);
    }
}
