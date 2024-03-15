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

@WebServlet(name = "modifierCompteController", value = "/modifierCompteController")
public class modifierCompteController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int id= Integer.parseInt(request.getParameter("id"));
        try {
            CompteDAO c1d = new CompteDAO();
            c1d.ModifierComptes(id,login,password);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        finally {
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
