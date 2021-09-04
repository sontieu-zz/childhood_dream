package com.sontieu.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sontieu.spring.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
	 List<Train> findAll();
}
