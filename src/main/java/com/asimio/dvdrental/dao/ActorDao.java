package com.asimio.dvdrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asimio.dvdrental.model.Actor;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {
}