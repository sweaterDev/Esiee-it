package com.example.projetgreta2.controller.matiere;

import com.example.projetgreta2.model.Matiere;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.projetgreta2.dao.MatiereDAO;

@WebServlet(name = "ModifierMatiereControllerServlet", value = "/modifierMatiereController")
public class ModifierMatiereController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        MatiereDAO matiereDAO = null;
        try {
            matiereDAO = new MatiereDAO();
            ArrayList<Matiere> listeMatieres = matiereDAO.listerMatieres(); // Suppose que vous avez cette méthode dans MatiereDAO
            request.setAttribute("listeMatieres", listeMatieres);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            matiereDAO.modifierMatiere(id, nom); // Assurez-vous d'avoir cette méthode dans MatiereDAO
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer l'erreur
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/matiere.jsp");
        dispatcher.forward(request, response);
         // Assurez-vous d'avoir une route pour lister les matières
    }
}
