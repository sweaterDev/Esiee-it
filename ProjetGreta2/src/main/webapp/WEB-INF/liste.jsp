<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.projetgreta2.model.Compte, com.example.projetgreta2.dao.MatiereDAO, com.example.projetgreta2.model.Matiere, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Comptes et Spécialités</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }
        table {
            border-collapse: collapse;
            width: 60%; /* Ajustez la largeur selon vos besoins */
            margin-top: 20px;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        form {
            display: inline-block; /* Permet d'afficher les boutons sur la même ligne */
        }
    </style>
</head>
<body>
<%
    Compte compteUtilisateur = (Compte)session.getAttribute("user");
    if (compteUtilisateur !=null) {
%>
<div> Bonjour <%=compteUtilisateur.getLogin() %> </div>
<a href="deconnexion">Déconnexion</a>
<% } %>
<h2>Liste des Comptes et Leurs Spécialités</h2>

<div>
    <table align="center">
        <thead>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>Actions</th>
            <th>Spécialités</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Compte> listeComptes = (ArrayList<Compte>) request.getAttribute("listeComptes");
            MatiereDAO matiereDAO = new MatiereDAO();
            if(listeComptes != null){
                for(Compte compte : listeComptes){
                    ArrayList<Matiere> specialites = matiereDAO.listerMatieresParCompte(compte.getId());
        %>
        <tr>
            <td><%= compte.getLogin() %></td>
            <td><%= compte.getPassword() %></td>
            <td>
                <form action="modifierCompteServlet" method="post">
                    <input type="hidden" name="modifie" value="<%= compte.getId() %>" />
                    <input type="submit" value="Modifier" />
                </form>
                <form action="supprimerCompteController" method="post">
                    <input type="hidden" name="delete" value="<%= compte.getId() %>" />
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce compte ?');" />
                </form>
            </td>
            <td>
                <% for (Matiere matiere : specialites) { %>
                <%= matiere.getNom() %>
                <form action="supprimerSpecialite" method="post" style="display: inline;">
                    <input type="hidden" name="idCompte" value="<%= compte.getId() %>" />
                    <input type="hidden" name="idMatiere" value="<%= matiere.getId() %>" />
                    <input type="submit" value="Supprimer" />
                </form>
                <br>
                <% } %>
                <form action="ajouterSpecialiteForm" method="get">
                    <input type="hidden" name="idCompte" value="<%= compte.getId() %>" />
                    <input type="submit" value="Ajouter Spécialité" />
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<div>
    <form action="ajouterCompteForm" method="post">
        <input type="submit" value="Ajouter Nouveau Compte">
    </form>
</div>
</body>
</html>
