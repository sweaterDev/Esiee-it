package com.example.projetgreta2.view;



import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "resultServlet", value = "/result")
public class Result extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        }







    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérez les données du formulaire
        String nom = request.getParameter("nom");
        String heures = request.getParameter("heures");

        // Traitez les données, par exemple, stockez-les en session
        HttpSession session = request.getSession();
        session.setAttribute("nom", nom);
        session.setAttribute("heures", heures);

        // Ici, vous pouvez générer une réponse ou rediriger vers une page JSP
        // Par exemple, afficher les résultats
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Résultat</h1>");
        out.println("<p>Nom: " + nom + "</p>");
        out.println("<p>Heures: " + heures + "</p>");
        out.println("</body></html>");
    }

        public void destroy () {
        }
    }