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
public class NewCardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		List<Account> currentAccounts= AccountService.getInstance().getAllCurrentAccounts(id);
		req.setAttribute("id", id);
		req.setAttribute("currentAccounts", currentAccounts);
		req.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/newCard.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strCmpt = req.getParameter("idAccount");
		Integer id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("typeDeCarte");
		req.setAttribute("id", id);
        if (strCmpt == null || strCmpt.isEmpty() || type == null) {
        	this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_newCard.jsp").forward(req, resp);
        } else {
        	
    		Integer idAccount = Integer.parseInt(strCmpt);
          
            Boolean cardOK = AccountService.getInstance().newCard(idAccount, type);
            
        	if (!cardOK) {
        		this.getServletContext().getRequestDispatcher("/WEB-INF/views/newCard.jsp").forward(req, resp);
        	} else {
        		this.getServletContext().getRequestDispatcher("/WEB-INF/views/newCard_OK.jsp").forward(req, resp);
        }
        }
    }
}
