package com.example.projetgreta2.controller.matiere;

import com.example.projetgreta2.model.Matiere;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import com.example.projetgreta2.dao.MatiereDAO;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AjouterMatiereController", value = "/ajouterMatiereController")
public class AjouterMatiereController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nom");

        try {
            MatiereDAO matiereDAO = new MatiereDAO();
            matiereDAO.ajouterMatiere(nom); // Assurez-vous que cette méthode existe dans MatiereDAO

            // Après l'ajout, récupérer la liste mise à jour des matières pour l'affichage
            ArrayList<Matiere> listeMatieres = matiereDAO.listerMatieres(); // Assurez-vous que cette méthode existe dans MatiereDAO
            request.setAttribute("listeMatieres", listeMatieres);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'exception
        }

        // Rediriger vers la vue qui liste les matières
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/matiere.jsp");
        dispatcher.forward(request, response);
    }
}
