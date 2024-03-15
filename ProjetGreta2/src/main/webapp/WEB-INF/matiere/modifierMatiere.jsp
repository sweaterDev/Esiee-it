<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.projetgreta2.model.Matiere" %>
<!DOCTYPE html>
<html>
<head>
  <title>Modifier Matière</title>
  <!-- Style -->
</head>
<body>
<%
  int id = (int)request.getAttribute("id");

%>
<div> Bonjour, <%= request.getAttribute("user") %></div>
<h1>Modifier Matière</h1>
<form action="modifierMatiereController" method="post" class="form-example" enctype="application/x-www-form-urlencoded">
  <div class="form-example">
    <input type="hidden" name="id" id="id" value="<%= id%>" />
    <label for="nom">Nom de la matière :</label>
    <input type="text" name="nom" id="nom"required />
  </div>
  <div class="form-example">
    <input type="submit" value="Modifier" />
  </div>
</form>

</body>
</html>
