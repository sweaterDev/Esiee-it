<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.projetgreta2.model.Compte" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    /* Style pour centrer le formulaire et ajuster les couleurs */
    body {
      background-color: #F0F0F0; /* Couleur de fond similaire à celle de la page de chat OpenAI */
      color: #000000; /* Couleur du texte similaire à celle de la page de chat OpenAI */
      font-family: Arial, sans-serif; /* Police de caractère */
      display: flex;
      justify-content: center; /* Centre le contenu horizontalement */
      align-items: center; /* Centre le contenu verticalement */
      min-height: 100vh; /* Hauteur minimale de la vue */
      margin: 0; /* Annule les marges par défaut */
    }
    .form-example {
      background-color: #FFFFFF; /* Fond blanc pour le formulaire */
      padding: 20px;
      border-radius: 8px; /* Bords arrondis pour le formulaire */
      box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Ombre subtile */
      width: 100%;
      max-width: 400px; /* Largeur maximale du formulaire */
    }
    .form-example input[type="text"], .form-example input[type="submit"] {
      width: 100%; /* Pleine largeur pour les champs de saisie et le bouton */
      padding: 10px;
      margin: 10px 0; /* Marge entre les éléments du formulaire */
      border: 1px solid #cccccc; /* Bordure des champs de saisie */
      border-radius: 4px; /* Bords arrondis pour les champs de saisie */
    }
    .form-example input[type="submit"] {
      background-color: #007BFF; /* Couleur de fond pour le bouton */
      color: white; /* Couleur du texte pour le bouton */
      cursor: pointer; /* Change le curseur en pointeur */
    }
    .form-example input[type="submit"]:hover {
      background-color: #0056b3; /* Couleur de fond au survol pour le bouton */
    }
    label {
      display: block; /* Les labels prennent toute la largeur */
      margin-bottom: 5px; /* Marge en bas des labels */
    }
  </style>
</head>
<body>
<%
  Compte compte1 = (Compte)session.getAttribute("user");
  if (session.getAttribute("user") !=null) {
%>
<div> bonjour <%=compte1.getLogin() %> </div>
<%}
%>
<h1>Ajouter un Nouveau compte</h1>
<form action="modifierCompteController" method="post" class="form-example" enctype="application/x-www-form-urlencoded">
  <div class="form-example">
    <label for="login">Login</label>
    <input type="text" name="login" id="login" required />
  </div>
  <div class="form-example">
    <label for="password">Password :</label>
    <input type="text" name="password" id="password" required />
  </div>
  <div class="form-example">
    <input type="submit" id="id" name="id" value=<%= request.getAttribute("id")%> />
  </div>
</form>
</body>
</html>

