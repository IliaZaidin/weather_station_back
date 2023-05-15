package ilia.weatherstation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ilia.weatherstation.model.Reading;
import ilia.weatherstation.model.ReadingIn;
import ilia.weatherstation.repo.ReadingService;

@RestController
@RequestMapping("/readings")

public class ReadingsController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAllReadings() {
        return new ResponseEntity<>(readingService.all(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneReading(@PathVariable Long id) {
        return new ResponseEntity<>(readingService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> insertReading(@RequestBody ReadingIn readingIn) {
        Reading reading = readingIn.toReading();
        reading = readingService.save(reading);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateReading(@PathVariable Long id, @RequestBody ReadingIn reading) {
        Optional<Reading> dbReading = readingService.findById(id);
        if (dbReading.isEmpty())
            throw new RuntimeException("Reading with id: " + id + " not found");
        reading.updateReading(dbReading.get());
        Reading updatedReading = readingService.save(dbReading.get());
        return new ResponseEntity<>(updatedReading, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReading(@PathVariable Long id) {
        Optional<Reading> dbReading = readingService.findById(id);
        if (dbReading.isEmpty())
            throw new RuntimeException("Reading with id: " + id + " not found");
        readingService.delete(dbReading.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }
}