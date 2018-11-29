package br.upf.ads.controleFrota.uteis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = null;
	
	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory =  Persistence.createEntityManagerFactory("ControleFrota");
		}
		return factory.createEntityManager();
	}
	
	
}
