package com.asimio.dvdrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asimio.dvdrental.model.Actor;

public interface ActorDao extends JpaRepository<Actor, Integer> {
}