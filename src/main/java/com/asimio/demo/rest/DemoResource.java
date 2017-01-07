package com.asimio.demo.rest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asimio.dvdrental.dao.ActorDao;
import com.asimio.dvdrental.model.Actor;

@RestController
@RequestMapping(value = "/demo")
@Transactional
public class DemoResource {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping(method = RequestMethod.GET)
	public String getDemo() {
		Actor actor = this.actorDao.getOne(1);
		return String.format("[actor: %s %s], [DemoResource instance: %s], [ActorDao instance: %s]", actor.getFirstName(),
			actor.getLastName(), this, this.actorDao);
	}
}