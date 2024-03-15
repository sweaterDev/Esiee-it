package com.example.projetgreta2.controller.matiere;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ajouterMatiereServlet", value = "/ajouterMatiereServlet")
public class AjouterMatiereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers ajouterMatiere.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/ajouterMatiere.jsp");
        dispatcher.forward(request, response);
    }
}