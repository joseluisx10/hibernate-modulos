package com.hibernate.components;
import javax.persistence.*;

public class ConectorJPA {
	private EntityManagerFactory emf;

	public ConectorJPA() {
		emf = Persistence.createEntityManagerFactory("mariadb");
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
