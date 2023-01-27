package dev.webapptest.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EditerCollaborateurController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matriculeParam = req.getParameter("matricule");
        if(matriculeParam == null){
            resp.sendError(400, "Un matricule est attendu");
        }

        resp.setContentType("text/html");
        resp.getWriter().write("<h2>Edition de collaborateur</h2>" +
                "Matricule : " + matriculeParam);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> parameters = new HashMap<>();
        //Liste des paramètres
        parameters.put("matricule", "");
        parameters.put("titre", "");
        parameters.put("nom", "");
        parameters.put("prenom", "");

        for (Map.Entry<String, String> entry: parameters.entrySet()
             ) {
            entry.setValue(req.getParameter(entry.getKey()));
        }


        if(parameters.values().contains(null)){
            String message = "Les paramèters suivants sont incorrects : \n" +
            parameters.entrySet().stream().filter(set -> set.getValue() == null).map(set -> set.getKey()).collect(Collectors.joining("\n"));
            resp.sendError(400, message);
        }

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>Création d'un collaborateur avec les informations suivantes : </h1>" +
                "<ul>" +
                "<li>" + parameters.entrySet().stream().map(set -> set.getKey() + "=" + set.getValue()).collect(Collectors.joining(",")) + "</li>");
        resp.setStatus(201);
    }
}
