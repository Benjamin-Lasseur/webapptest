package dev.webapptest.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListerCollaborateurController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String avecPhotoParam = req.getParameter("avecPhoto");
        String departementParam = req.getParameter("departement");

        resp.setContentType("text/html");

        resp.getWriter().write("<h1>Liste des collaborateurs</h1>"
                + "<ul>"
                + "<li>avecPhoto "+ avecPhotoParam + "</li>"
                + "<li>departement "+ departementParam + "</li>"
                + "</ul>"
        );
    }
}
