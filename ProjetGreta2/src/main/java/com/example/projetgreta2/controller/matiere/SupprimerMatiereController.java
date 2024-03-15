package com.example.projetgreta2.controller.matiere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import com.example.projetgreta2.dao.MatiereDAO;
import com.example.projetgreta2.model.Matiere;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SupprimerMatiereController", value = "/supprimerMatiereController")
public class SupprimerMatiereController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // La gestion de la requête GET peut être ici si nécessaire.
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            MatiereDAO matiereDAO = new MatiereDAO();
            matiereDAO.supprimerMatiere(id); // Assurez-vous d'avoir cette méthode dans MatiereDAO

            // Après suppression, récupérer la liste mise à jour des matières pour l'affichage
            ArrayList<Matiere> listeMatieres = matiereDAO.listerMatieres(); // Assurez-vous d'avoir cette méthode dans MatiereDAO
            request.setAttribute("listeMatieres", listeMatieres);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Ici, vous pouvez gérer les exceptions plus proprement, par exemple, en envoyant un message d'erreur à la vue
        }

        // Rediriger vers la vue qui liste les matières (ajustez le chemin si nécessaire)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/matiere/matiere.jsp");
        dispatcher.forward(request, response);
    }
}
