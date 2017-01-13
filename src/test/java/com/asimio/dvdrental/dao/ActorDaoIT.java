package com.asimio.dvdrental.dao;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asimio.demo.config.dvdrental.DvdRentalTenantContext;
import com.asimio.demo.main.Application;
import com.asimio.dvdrental.dao.ActorDao;
import com.asimio.dvdrental.model.Actor;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ActorDaoIT {

	@Autowired
	private ActorDao actorDao;

	@BeforeClass
	public static void beforeClass() {
		DvdRentalTenantContext.setTenantId("tenant_1");
	}

	@Test
	public void shouldHave200Actors() {
		Assert.assertThat(this.actorDao.count(), Matchers.equalTo(200L));
	}

	@Test
	public void actorShouldBePenelope() {
		Actor actor = this.actorDao.findOne(1);
		Assert.assertThat(actor.getFirstName(), Matchers.equalTo("Penelope"));
	}
}