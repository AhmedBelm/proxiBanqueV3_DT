package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.AccountService;

public class AddCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idAccount = Integer.parseInt(req.getParameter("idAccount"));
		if (AccountService.getInstance().newCard(idAccount, "visaPremier")) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/WEB-INF/views/newcard.jsp");			
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/error_card.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idAccount = Integer.parseInt(req.getParameter("idAccount"));
		String type = req.getParameter("typeDeCarte");
		Boolean cardOK = AccountService.getInstance().newCard(idAccount, type);
		
		if (!cardOK) {
			req.setAttribute("idAccount", type);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/newcard.jsp").forward(req, resp);
		} else {
			this.getServletContext().getRequestDispatcher("WEB-INF/views/cardOK.jsp").forward(req, resp);
		}
		
	}
}
