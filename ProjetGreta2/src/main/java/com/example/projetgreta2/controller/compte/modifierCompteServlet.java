package com.example.projetgreta2.controller.compte;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "modifierCompteServlet", value = "/modifierCompteServlet")
public class modifierCompteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logique pour traiter l'ajout d'un nouveau compte, si nécessaire

        // Redirection vers ajouterCompte.jsp
        request.setAttribute("id", Integer.parseInt(request.getParameter("modifie")));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/compte/modifierCompte.jsp");
        dispatcher.forward(request, response);
    }
}