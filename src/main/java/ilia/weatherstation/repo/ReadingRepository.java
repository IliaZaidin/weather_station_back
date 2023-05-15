package ilia.weatherstation.repo;

import org.springframework.data.repository.CrudRepository;

import ilia.weatherstation.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading,Long> {
}
