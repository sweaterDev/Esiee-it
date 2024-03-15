package com.example.projetgreta2.controller.compte;
import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import com.example.projetgreta2.model.Compte;
import com.example.projetgreta2.dao.CompteDAO;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "formcontrollerServlet", value = "/formcontroller")
public class formController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Compte c1 = new Compte();
        c1.setLogin(login);
        c1.setPassword(password);

        try {
            CompteDAO c1d = new CompteDAO();
            if (c1d.verifierCompte(c1)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", c1);
                // Si le compte est vérifié, récupérez l'ArrayList de comptes
                ArrayList<Compte> listeComptes = c1d.afficherCompteDao();

                // Définissez l'ArrayList comme un attribut de requête
                request.setAttribute("listeComptes", listeComptes);

                // Utilisez RequestDispatcher pour forwarder la requête et la réponse à liste.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/liste.jsp");
                dispatcher.forward(request, response);
            } else {
                // Redirection vers index.jsp si la vérification échoue
                response.sendRedirect("/WEB-INF/index.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
