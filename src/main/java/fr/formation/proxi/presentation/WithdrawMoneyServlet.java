package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.Account;
import fr.formation.proxi.metier.AccountService;
import fr.formation.proxi.metier.Client;
import fr.formation.proxi.metier.ClientService;

/**
 * Classe héritant de HttpServlet et utilisant doGet() et doPost.
 * 
 * @author Ahmed & Sidney
 *
 */
public class WithdrawMoneyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AccountService accS = AccountService.getInstance();
	
	/**
	 * Methode permettant d'acceder a� la page de transfer. Recupere l'id dy
	 * client de la requete pour agir sur ses comptes specifiquement. Renvoie en
	 * attribut une liste des comptes dudit client. Si le client possede 1 compte
	 * ou moins, l'utilisateur est transfere sur une page d'erreur.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		List<Account> accounts = this.accS.getAll(id);
		req.setAttribute("accounts", accounts);
		req.setAttribute("client", client);
		req.setAttribute("clientId", id);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/withdrawMoney.jsp").forward(req, resp);
	}
	
	
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer compteDebite = Integer.parseInt(req.getParameter("compteADebiter"));
        Integer clientId = Integer.parseInt(req.getParameter("id"));
        Float val = Float.parseFloat(req.getParameter("value"));

        Boolean withdrawOK = ClientService.getInstance().withdraw(val, compteDebite, clientId);

        if (!withdrawOK) {
            req.setAttribute("withdrawRate", withdrawOK);
            req.setAttribute("clientId", clientId);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/withdrawMoney.jsp").forward(req, resp);
        } else {
        	req.setAttribute("clientId", clientId);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/withdrawMoney_OK.jsp").forward(req, resp);
        }
    }
}

