package com.example.projetgreta2.controller.matiere;

import com.example.projetgreta2.dao.MatiereDAO;
import com.example.projetgreta2.model.Matiere;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "redirectVueMatiere", urlPatterns = {"/redirectVueMatiere"})
public class RedirectVueMatiere extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logique pour préparer des données si nécessaire
        MatiereDAO matiereDAO = null;
        try {
            matiereDAO = new MatiereDAO();
            ArrayList<Matiere> listeMatieres = matiereDAO.listerMatieres(); // Suppose que vous avez cette méthode dans MatiereDAO
            request.setAttribute("listeMatieres", listeMatieres); // Définir l'attribut de requête
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'exception ou définir un attribut d'erreur si nécessaire
        }


        // Redirection vers matiere.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/matiere.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vous pouvez également gérer POST si nécessaire
        doGet(request, response);
    }
}
