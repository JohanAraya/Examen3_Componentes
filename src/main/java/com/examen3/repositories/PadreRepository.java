package com.examen3.repositories;

import com.examen3.domain.Padre;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PadreRepository extends JpaRepository<Padre, Long> {

}
