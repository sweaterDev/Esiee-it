package com.example.projetgreta2.dao;

import com.example.projetgreta2.model.Specialite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecialiteDAO {
    private Connexion connexion;

    public SpecialiteDAO() throws SQLException, ClassNotFoundException {
        this.connexion = new Connexion();
    }

    public void ajouterSpecialite(int idCompte, int idMatiere) throws SQLException {
        String sql = "INSERT INTO Specialite (id_compte, id_matiere) VALUES (?, ?)";
        try (PreparedStatement statement = connexion.conn.prepareStatement(sql)) {
            statement.setInt(1, idCompte);
            statement.setInt(2, idMatiere);
            statement.executeUpdate();
        }
    }

    public void supprimerSpecialite(int idCompte, int idMatiere) throws SQLException {
        String sql = "DELETE FROM Specialite WHERE id_compte = ? AND id_matiere = ?";
        try (PreparedStatement statement = connexion.conn.prepareStatement(sql)) {
            statement.setInt(1, idCompte);
            statement.setInt(2, idMatiere);
            statement.executeUpdate();
        }
    }

    // Potentiellement, d'autres méthodes pour gérer les spécialités...
}
