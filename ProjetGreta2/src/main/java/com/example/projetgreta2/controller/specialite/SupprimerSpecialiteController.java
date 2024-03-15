package com.example.projetgreta2.controller.specialite;

import com.example.projetgreta2.dao.SpecialiteDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import com.example.projetgreta2.dao.MatiereDAO;

@WebServlet(name = "SupprimerSpecialiteController", value = "/supprimerSpecialite")
public class SupprimerSpecialiteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCompte = Integer.parseInt(request.getParameter("idCompte"));
        int idMatiere = Integer.parseInt(request.getParameter("idMatiere"));
        try {
            SpecialiteDAO specialiteDAO = new SpecialiteDAO();
            specialiteDAO.supprimerSpecialite(idCompte, idMatiere);
        } catch (Exception e) {
            e.printStackTrace();

        }
        response.sendRedirect("listeSpecialites?idCompte=" + idCompte); // Assurez-vous d'avoir ce contrôleur/view
    }
}
