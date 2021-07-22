package com.console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Console {

	public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;
        
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPAunitePersitence");
            em = entityManagerFactory.createEntityManager();


        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

	}

}
