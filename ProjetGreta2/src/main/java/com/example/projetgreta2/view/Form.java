package com.example.projetgreta2.view;



import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formServlet", value = "/form")
public class Form extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<form action=\"formcontroller\" method=\"post\" class=\"form-example\" enctype=\"application/x-www-form-urlencoded\">\n" +
                "  <div class=\"form-example\">\n" +
                "    <label for=\"name\"> nom: </label>\n" +
                "    <input type=\"text\" name=\"nom\" id=\"name\" required />\n" +
                "  </div>\n" +
                "  <div class=\"form-example\">\n" +
                "    <label for=\"email\">nb heures: </label>\n" +
                "    <input type=\"text\" name=\"heures\" id=\"email\" required />\n" +
                "  </div>\n" +
                "  <div class=\"form-example\">\n" +
                "    <input type=\"submit\" value=\"Crée cette matière\" />\n" +
                "  </div>\n" +
                "</form>\n");


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des données du formulaire
        String nom = request.getParameter("nom");
        String heures = request.getParameter("heures");

        // Stocker les données en session ou effectuer des opérations
        HttpSession session = request.getSession();
        session.setAttribute("nom", nom);
        session.setAttribute("heures", heures);

        // Redirection vers result.html
        response.sendRedirect("result.html");
    }
    public void destroy() {
    }
}