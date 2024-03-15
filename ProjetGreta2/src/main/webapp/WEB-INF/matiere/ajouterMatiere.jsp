<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ajouter une Nouvelle Matière</title>
  <style>
    /* Reprise du style de ajouterCompte.jsp */
    body {
      background-color: #F0F0F0;
      color: #000000;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      margin: 0;
    }
    .form-example {
      background-color: #FFFFFF;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      width: 100%;
      max-width: 400px;
    }
    .form-example input[type="text"], .form-example input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #cccccc;
      border-radius: 4px;
    }
    .form-example input[type="submit"] {
      background-color: #007BFF;
      color: white;
      cursor: pointer;
    }
    .form-example input[type="submit"]:hover {
      background-color: #0056b3;
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
  </style>
</head>
<body>

<h1>Ajouter une Nouvelle Matière</h1>
<form action="ajouterMatiereController" method="post" class="form-example" enctype="application/x-www-form-urlencoded">
  <div class="form-example">
    <label for="nom">Nom de la matière :</label>
    <input type="text" name="nom" id="nom" required />
  </div>
  <div class="form-example">
    <input type="submit" value="Ajouter" />
  </div>
</form>

</body>
</html>
