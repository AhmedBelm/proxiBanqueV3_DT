package fr.formation.proxi.presentation;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.Client;
import fr.formation.proxi.metier.ClientService;



public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	/**
	 * Methode permettant d'acceder a� index.jsp.
	 * Recupere et renvoie en attribut une liste des clients issus de ClientService. 
	 * Cette liste sera affichee dans index.jsp. 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 this.getServletContext()
	        .getRequestDispatcher("/index.jsp")
	        .forward(req, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        String mot[] = req.getParameter("name").split(" ");
        String lastname = mot[1];
        String firstname = mot[0];
        System.out.println(firstname + lastname);
        Client client = ClientService.getInstance().check(firstname, lastname);
        if ( client == null ) {
            
            this.getServletContext()
            .getRequestDispatcher("/WEB-INF/views/error.jsp")
            .forward(req, resp);
            
        } else {
            Integer Id = client.getIdClient();
            System.out.println(Id);
            resp.sendRedirect(
                    this.getServletContext().getContextPath() + "/dashbord.html?id="+Id);
            
        }
        
        
        
        //for (Client client : clients)
        
        
    }


}
