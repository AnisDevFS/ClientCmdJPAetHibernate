package com.console;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entities.Client;
import com.entities.Commande;
import com.entities.Compte;
import com.entities.Voiture;


public class Console {
	

    public static void main(String[] args) throws Exception {
    	
        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;

        Client nga = new Client("Nga", "nga@pop.fr", "0000", 30);
        Client seb = new Client( "Sébastien", "seb@pop.fr", "0000", 40);
        Client anis = new Client( "Anis", "anis@pop.fr", "0000", 40);
        
        Commande cmd1 = new Commande("Chaussure", 2, 100, new Date());
        Commande cmd2 = new Commande("Nike", 20, 200, new Date());

        List<Commande> commandesDeSeb = new ArrayList<>();
        commandesDeSeb.add(cmd1);   commandesDeSeb.add(cmd2);  
        
        seb.setCommandes(commandesDeSeb);
        
        Commande cmd3 = new Commande("Chaussure de nga", 2, 100, new Date());
        Commande cmd4 = new Commande("Adidas", 20, 200, new Date());

        List<Commande> commandesDeNga = new ArrayList<>();
        commandesDeNga.add(cmd3);   commandesDeNga.add(cmd4);  
        
        nga.setCommandes(commandesDeNga);
        
        Compte c1 = new Compte("le compte de Seb", 300);
        Compte c2 = new Compte("le compte de Nga", 3000);
        
        nga.setCompte(c2);
        seb.setCompte(c1);
        
        Voiture bmw = new Voiture("v6sefv46", "BMW", "noir");
        Voiture mini = new Voiture( "mini6584c6e4rouge", "Mini Cooper", "rouge");
        Voiture ferrari = new Voiture("v6sefv46", "ferrari", "jaune");
        Voiture mini2 = new Voiture( "mini6584c6e4rouge", "Mini 2", "rose");
        
        List<Voiture> voituresDeNga = new ArrayList<>();
        List<Voiture> voituresDeSeb = new ArrayList<>();
        voituresDeNga.add(mini2); voituresDeNga.add(mini);
        voituresDeNga.add(bmw);
//        
        voituresDeSeb.add(bmw); voituresDeSeb.add(ferrari);
        nga.setVoitures(voituresDeNga);
        seb.setVoitures(voituresDeSeb);
        
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPAunitePersitence");
            em = entityManagerFactory.createEntityManager();
            
            EntityTransaction trans = em.getTransaction();
            List<Client> clients = em.createQuery( "from Client", Client.class ).getResultList();
//            trans.begin();
            for (Client client : clients) {
				
	            	System.out.println(client);		
			}  
//            
           Client sebb= em.find(Client.class, 1);
           System.out.println("--------------------");
           System.out.println(sebb);
//            em.remove(sebb);
//          em.persist(nga);
//			em.persist(seb);
//			em.persist(nga);
//			em.persist(anis);
//            em.flush();
//            trans.commit();

        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}

