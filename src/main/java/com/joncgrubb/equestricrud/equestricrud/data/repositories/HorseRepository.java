package com.joncgrubb.equestricrud.equestricrud.data.repositories;

import com.joncgrubb.equestricrud.equestricrud.data.entities.Horse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {

}
