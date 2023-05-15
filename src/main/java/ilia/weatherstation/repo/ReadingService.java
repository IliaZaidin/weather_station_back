package ilia.weatherstation.repo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ilia.weatherstation.model.Reading;

@Service
public class ReadingService {

  @Autowired
  ReadingRepository repository;

  public Iterable<Reading> all() {
    return repository.findAll();
  }

  public Optional<Reading> findById(Long id) {
    return repository.findById(id);
  }

  public Reading save(Reading reading) {
    return repository.save(reading);
  }

  public void delete(Reading reading) {
    repository.delete(reading);
  }
}
