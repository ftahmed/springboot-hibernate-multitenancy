package com.asimio.dvdrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asimio.dvdrental.model.FilmActor;

@Repository
public interface FilmActorDao extends JpaRepository<FilmActor, Integer> {
}