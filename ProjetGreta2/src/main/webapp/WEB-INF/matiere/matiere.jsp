<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.projetgreta2.model.Matiere" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Gestion des Matières</title>
  <style>
    /* Votre CSS ici */
    body {
      font-family: Arial, sans-serif;
      display: flex;
      flex-direction: column;
      align-items: center;
      min-height: 100vh;
      margin: 0;
      background-color: #f0f0f0;
    }
    table {
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      text-align: left;
      padding: 8px;
      border: 1px solid #ddd;
    }
    th {
      background-color: #4CAF50;
      color: white;
    }
    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>

<h2>Liste des Matières</h2>

<div>
  <table>
    <tr>
      <th>ID</th>
      <th>Nom</th>
      <th>Actions</th>
    </tr>
    <%
      List<Matiere> listeMatieres = (List<Matiere>) request.getAttribute("listeMatieres");
      if(listeMatieres != null){
        for(Matiere matiere : listeMatieres){
    %>
    <tr>
      <td><%= matiere.getId() %></td>
      <td><%= matiere.getNom() %></td>
      <td>
        <form action="redirigerModifierMatiere" method="get">
          <input type="hidden" name="modifie" id="modifie" value="<%= matiere.getId() %>" />
          <input type="submit" value="Modifier" />
        </form>
        <form action="supprimerMatiereController" method="post">
          <input type="hidden" name="id" id="id" value="<%= matiere.getId() %>" />
          <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette matière ?');" />
        </form>
      </td>
    </tr>
    <%  }
    }
    %>
  </table>
</div>

<div>
  <h3>Ajouter une nouvelle matière</h3>
  <form action="ajouterMatiereServlet" method="get">

    <input type="submit" value="Ajouter">
  </form>
</div>

</body>
</html>