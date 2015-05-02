package br.com.caelum.notasfiscais.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil { 

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("notas");

	/**
	 * Criar uma instancia do EntityManager
	 * 
	 * @returnEntityManager
	 */
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	/*
	 * @dispose Destroy o EntityManager no final do Request
	 */
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}

}