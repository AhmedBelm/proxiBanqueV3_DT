package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxi.metier.Account;
import fr.formation.proxi.metier.Client;
import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.ClientService;

/**
 * Classe qui gère les relation entre la page web du tableau de bord et les différents comptes
 * 
 * @author Ahmed & Sidney
 *
 */
public class DashbordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DashbordServlet.class.getName());
	
	/**
	 * Methode permettant d'acceder a account.jsp. 
	 * Recupere l'id du client dans la requete, et renvoie en attribut une liste de comptes courant et une liste de comptes epargne, toutes deux liees au-dit client. 
	 * Renvoie en attribut l'id client.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Account> currentAccounts= AccountService.getInstance().getAllCurrentAccounts(id);
		List<Account> savingAccounts= AccountService.getInstance().getAllSavingAccounts(id);
		Client client = ClientService.getInstance().read(id);
		
		req.setAttribute("currentAccounts",currentAccounts);
		req.setAttribute("savingAccounts",savingAccounts);
		req.setAttribute("id",id);
		req.setAttribute("client",client);
		logger.info("Comptes du client " + client.getLastname() + " " + client.getFirstname() + " charg�s");
		
		req.getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp").forward(req, resp);
	}
}
