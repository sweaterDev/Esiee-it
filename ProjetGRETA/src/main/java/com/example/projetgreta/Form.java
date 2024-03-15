package com.example.projetgreta;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;


public class Form extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        out.println("<div>hello</div>");

    }

    public void destroy() {
    }
}
