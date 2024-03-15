package com.example.projetgreta2.controller.compte;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeconnexionServlet", value = "/deconnexion")
public class DeconnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pour la gestion de déconnexion via un lien
        handleLogout(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pour la gestion de déconnexion via un bouton
        handleLogout(request, response);
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Les proxies.

        HttpSession session = request.getSession(false); // Récupérer la session sans en créer une nouvelle
        if (session != null) {
            session.invalidate(); // Invalider la session
        }
        response.sendRedirect("index.jsp"); // Rediriger vers la page de connexion
    }
}
