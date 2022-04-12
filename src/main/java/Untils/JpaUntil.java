package Untils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUntil {
	public static EntityManagerFactory getFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PH13751_LeMinhThuy_Assignment");
		
		return factory ;
	}
	
	public static EntityManager getManager() {
		EntityManager em = JpaUntil.getFactory().createEntityManager();
		
		return em ; 
	}
}
