package com.example.projetgreta2.controller.matiere;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirigerModifierMatiereServlet", value = "/redirigerModifierMatiere")
public class ModifierMatiereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logique pour traiter l'ajout d'un nouveau compte, si nécessaire
        if (request.getParameter("modifie") !=null) {
            request.setAttribute("id", Integer.parseInt(request.getParameter("modifie")));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/modifierMatiere.jsp");
            dispatcher.forward(request, response);

        }
        // Redirection vers ajouterCompte.jsp

    }
}