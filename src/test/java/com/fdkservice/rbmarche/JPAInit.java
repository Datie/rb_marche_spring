package com.fdkservice.rbmarche;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fdkservice.rbmarche.entity.ShelveType;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

class JPAInit {
	/*
	private static EntityManagerFactory factory;
	//private static Logger logger = LogManager.getLogger();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		factory = Persistence.createEntityManagerFactory("rb");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select st from ShelveType st");
		List list = q.getResultList();
		for(int i = 0;list!= null && i < list.size();i++) {
			em.remove(list.get(i));
		}
		em.getTransaction().commit();
		em.getTransaction().begin();
		ShelveType st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(210);
		st.setWidth(100);
		st.setLength(150);
		st.setName("210");
		em.persist(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(180);
		st.setWidth(100);
		st.setLength(150);
		st.setName("180");
		em.persist(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(200);
		st.setWidth(100);
		st.setLength(150);
		st.setName("200");
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}

	@Test
	void initCreateShelveType() {
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select st from ShelveType st");
		List list = q.getResultList();
		for(int i = 0;list!= null && i < list.size();i++) {
			em.remove(list.get(i));
		}
		em.getTransaction().commit();
		em.getTransaction().begin();
		ShelveType st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(210);
		st.setWidth(100);
		st.setLength(150);
		st.setName("210");
		em.persist(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(180);
		st.setWidth(100);
		st.setLength(150);
		st.setName("180");
		em.persist(st);
		st = new ShelveType();
		st.setCreatedAt(new Date());
		st.setHeight(200);
		st.setWidth(100);
		st.setLength(150);
		st.setName("200");
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}
*/
}
