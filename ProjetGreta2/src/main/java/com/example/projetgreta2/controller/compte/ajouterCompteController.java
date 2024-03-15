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

@WebServlet(name = "ajouterCompteControllerServlet", value = "/ajouterCompteController")
public class ajouterCompteController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false); // Ne pas créer une nouvelle session ici
        if (session == null || session.getAttribute("user") == null) {
            // La session n'existe pas ou l'utilisateur n'est pas connecté, rediriger vers la page de connexion
            response.sendRedirect("index.jsp");
            return; // Important de retourner après la redirection pour ne pas continuer l'exécution
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            Compte c1 = new Compte();
            c1.setLogin(login);
            c1.setPassword(password);

            try {
                CompteDAO c1d = new CompteDAO();
                c1d.AjouterComptes(login, password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } finally {
                CompteDAO c1d = null;
                try {
                    c1d = new CompteDAO();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ArrayList<Compte> listeComptes = null;
                try {
                    listeComptes = c1d.afficherCompteDao();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                // Définissez l'ArrayList comme un attribut de requête
                request.setAttribute("listeComptes", listeComptes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/liste.jsp");
                dispatcher.forward(request, response);
            }
        }

    }


