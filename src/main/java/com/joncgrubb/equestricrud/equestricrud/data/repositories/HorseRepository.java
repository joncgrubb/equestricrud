package com.joncgrubb.equestricrud.equestricrud.data.repositories;

import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;

import org.springframework.data.repository.CrudRepository;

public interface HorseRepository extends CrudRepository<Horse, Long> {
    
}
