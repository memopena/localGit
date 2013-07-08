package com.ezcargo.entities;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration("PersistenceTests-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConsigPersistenceTest {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveConfig() throws Exception {
		Consig consig = new Consig();
		entityManager.persist(consig);
		entityManager.flush();
		assertNotNull(consig.getId());
	}

}
