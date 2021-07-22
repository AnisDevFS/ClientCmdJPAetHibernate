package com.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.entities.Client;
import com.entities.Commande;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ajout")
public class AjoutCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjoutCommande() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String produit = request.getParameter( "txtProduit" );
		String nombre = request.getParameter( "txtNombre" );	
		String prix = request.getParameter( "txtPrix" );
		
		int nombreInt = Integer.parseInt(nombre);
		int prixInt  = Integer.parseInt(prix);
		
		HttpSession session = request.getSession( true );
		Client connectedClient =  (Client) session.getAttribute( "connectedClient" );
		List <Commande> commandesClient = (List<Commande>) session.getAttribute("commandesClient");
		
		
		Commande c = new Commande(produit, nombreInt, prixInt, new Date()) ;

		EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;
        boolean cmdAdded = false;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ClientCommandeJPAunitePersitence");
            em = entityManagerFactory.createEntityManager();
            
            EntityTransaction trans = em.getTransaction();
            trans.begin(); 
            em.persist(c);
            commandesClient.add(c);
            cmdAdded = true;
            trans.commit();

        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
        session.setAttribute( "commandesClient", commandesClient );
        if (cmdAdded)
		request.getRequestDispatcher( "/cmd.jsp" ).forward( request, response );
        else request.getRequestDispatcher( "/AjoutCmd.jsp" ).forward( request, response );
		
	}

}
