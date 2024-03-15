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

import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "supprimerControllerServlet", value = "/supprimerCompteController")
public class supprimerCompteController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("delete"));
        ArrayList<Compte> listeComptes = new ArrayList<Compte>();
        try {
            CompteDAO cd1 = new CompteDAO();
            cd1.SupprierCompte(id);
            listeComptes = cd1.afficherCompteDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("listeComptes", listeComptes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/liste.jsp");
            dispatcher.forward(request, response);

        }
    }


