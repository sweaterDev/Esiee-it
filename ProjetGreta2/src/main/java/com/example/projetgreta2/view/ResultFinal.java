package com.example.projetgreta2.view;




import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "resultfinalServlet", value = "/resultfinal")
public class ResultFinal extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (session!=null) {

            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h1>Résultat</h1>");

            out.println("</body></html>");
        }


    }







    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérez les données du formulaire


        // Traitez les données, par exemple, stockez-les en session



        // Ici, vous pouvez générer une réponse ou rediriger vers une page JSP
        // Par exemple, afficher les résultats


    }

    public void destroy () {
    }
}
