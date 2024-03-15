package com.example.projetgreta2.dao;

import com.example.projetgreta2.model.Matiere;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatiereDAO {

    private Connexion connexion;

    public MatiereDAO() throws SQLException, ClassNotFoundException {
        this.connexion = new Connexion();
    }

    public ArrayList<Matiere> listerMatieres() throws SQLException {
        ArrayList<Matiere> matieres = new ArrayList<>();
        String reqSelect = "SELECT id_matiere, nom FROM Matiere";

        try (PreparedStatement pstmt = connexion.conn.prepareStatement(reqSelect);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Matiere matiere = new Matiere();
                matiere.setId(rs.getInt("id_matiere"));
                matiere.setNom(rs.getString("nom"));
                matieres.add(matiere);
            }
        }
        return matieres;
    }

    public void ajouterMatiere(String nom) throws SQLException {
        String reqInsert = "INSERT INTO Matiere (nom) VALUES (?)";

        try (PreparedStatement pstmt = connexion.conn.prepareStatement(reqInsert)) {
            pstmt.setString(1, nom);
            pstmt.executeUpdate();
        }
    }

    public void modifierMatiere(int id, String nouveauNom) throws SQLException {
        String reqUpdate = "UPDATE Matiere SET nom = ? WHERE id_matiere = ?";

        try (PreparedStatement pstmt = connexion.conn.prepareStatement(reqUpdate)) {
            pstmt.setString(1, nouveauNom);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public void supprimerMatiere(int id) throws SQLException {
        // Ici, vérifiez d'abord si la matière est spécialisée par quelqu'un.
        // Supposons qu'une autre table, disons `Specialite`, relie les matières aux personnes.
        // Si aucune entrée n'existe dans `Specialite` pour cette `id_matiere`, alors supprimez la matière.
        String reqCheck = "SELECT COUNT(*) FROM Specialite WHERE id_matiere = ?";
        try (PreparedStatement pstmtCheck = connexion.conn.prepareStatement(reqCheck)) {
            pstmtCheck.setInt(1, id);
            try (ResultSet rs = pstmtCheck.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) { // Si personne n'a cette matière en spécialité
                    String reqDelete = "DELETE FROM Matiere WHERE id_matiere = ?";
                    try (PreparedStatement pstmtDelete = connexion.conn.prepareStatement(reqDelete)) {
                        pstmtDelete.setInt(1, id);
                        pstmtDelete.executeUpdate();
                    }
                } else {
                    System.out.println("La matière est actuellement utilisée comme spécialité et ne peut pas être supprimée.");
                }
            }
        }
    }

    public ArrayList<Matiere> listerMatieresParCompte(int idCompte) throws SQLException {
        ArrayList<Matiere> matieres = new ArrayList<>();
        String sql = "SELECT m.id_matiere, m.nom FROM Specialite s " +
                "JOIN Matiere m ON s.id_matiere = m.id_matiere " +
                "WHERE s.id_compte = ?";

        try (PreparedStatement statement = connexion.conn.prepareStatement(sql)) {
            statement.setInt(1, idCompte);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Matiere matiere = new Matiere();
                    matiere.setId(resultSet.getInt("m.id_matiere"));
                    matiere.setNom(resultSet.getString("m.nom"));
                    matieres.add(matiere);
                }
            }
        }
        return matieres;
    }

    public static void main(String[] args) {
        try {
            MatiereDAO matiereDAO = new MatiereDAO();

            // Tester l'ajout d'une matière
            System.out.println("Ajout d'une nouvelle matière...");
            matiereDAO.ajouterMatiere("Mathématiques");
            System.out.println("Matière ajoutée.");

            // Lister toutes les matières
            System.out.println("Liste des matières après ajout :");
            for (Matiere matiere : matiereDAO.listerMatieres()) {
                System.out.println(matiere.getId() + " - " + matiere.getNom());
            }

            // Modifier une matière (changer le nom de "Mathématiques" en "Maths avancées")
            System.out.println("Modification d'une matière...");
            int idAModifier = 1; // Supposons que l'ID de "Mathématiques" est 1. À ajuster selon votre BD.
            matiereDAO.modifierMatiere(idAModifier, "Maths avancées");
            System.out.println("Matière modifiée.");

            // Lister toutes les matières après modification
            System.out.println("Liste des matières après modification :");
            for (Matiere matiere : matiereDAO.listerMatieres()) {
                System.out.println(matiere.getId() + " - " + matiere.getNom());
            }

            // Supprimer une matière (supposons qu'on veut supprimer la matière avec l'ID 1)
            System.out.println("Suppression d'une matière...");
            matiereDAO.supprimerMatiere(idAModifier);
            System.out.println("Matière supprimée.");

            // Lister toutes les matières après suppression
            System.out.println("Liste des matières après suppression :");
            for (Matiere matiere : matiereDAO.listerMatieres()) {
                System.out.println(matiere.getId() + " - " + matiere.getNom());
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

