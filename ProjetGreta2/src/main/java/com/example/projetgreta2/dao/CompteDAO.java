package com.example.projetgreta2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.projetgreta2.model.Compte;

public class CompteDAO {

public  Connexion connexion = new Connexion();

        public CompteDAO() throws SQLException, ClassNotFoundException {
        }


        public  ArrayList<Compte> afficherCompteDao() throws SQLException, ClassNotFoundException {

            if(connexion.conn.isClosed())
            {
                connexion = new Connexion();
            }
            String reqSelect= "SELECT id_compte,login,password"+" from compte";
            ArrayList<Compte> listCompte = new ArrayList<Compte>();

            try {
                PreparedStatement pstmt = connexion.conn.prepareStatement(reqSelect);
                //recupère un curseur sur les données
                ResultSet result1 = pstmt.executeQuery();
                //resulst1.next() retroune un booléen

                while (result1.next()){
                    Compte c1 = new Compte();
                    c1.setId(result1.getInt(1));
                    c1.setLogin(result1.getString(2));
                    c1.setPassword(result1.getString(3));
                    listCompte.add(c1);


                }
            }
            catch(SQLException  e){
                System.out.println("Problème");
                e.printStackTrace();
            }
            finally{
                if (connexion.conn != null) {
                    try {
                        connexion.conn.close();
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                        // throw new RuntimeException(e);
                    }

                }

            }
            return listCompte;
        }
        public  void supprimerLigneDao(int id) {
            String reqSelect= "Delete from acces where id = ?";

            try {
                Connexion connexion= new Connexion();
                PreparedStatement pstmt = connexion.conn.prepareStatement(reqSelect);
                pstmt.setInt(1, id);
                //recupère un curseur sur les données
                pstmt.executeUpdate();
            }
            catch(SQLException | ClassNotFoundException e){
                System.out.println("Problème");
                e.printStackTrace();
            }
            finally{
                if (connexion.conn != null) {
                    try {
                        connexion.conn.close();
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        public  void ModifierStatutDao(int id,String nouveauStatut) {

            String reqSelect= "Update acces set statut = ? where id = ?";
            Boolean deleted = false;

            try {

                PreparedStatement pstmt = connexion.conn.prepareStatement(reqSelect);
                pstmt.setString(1, nouveauStatut);
                pstmt.setInt(2, id);
                //recupère un curseur sur les données
                pstmt.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("Problème");
                e.printStackTrace();
            }
            finally{
                if (connexion != null) {
                    try {
                        connexion.conn.close();
                    }catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                // for testing
                System.out.println("table après modification");


            }
        }
        public  Boolean verifierCompte(Compte comptes) throws SQLException, ClassNotFoundException {
            if (connexion.conn.isClosed()) {
                connexion = new Connexion();
            }

            String reqSelect = "SELECT id_compte,login,password" + " from compte where login = ? and password = ?";
            boolean existe = false;

            try {
                PreparedStatement pstmt = connexion.conn.prepareStatement(reqSelect);
                pstmt.setString(1, comptes.getLogin());
                pstmt.setString(2, comptes.getPassword());
                ResultSet result1 = pstmt.executeQuery();
                existe = result1.first();
            } catch (SQLException e) {
                System.out.println("Problème");
                e.printStackTrace();
            } finally {
                if (connexion.conn != null) {
                    try {
                        connexion.conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
            return existe;
        }
            public  void AjouterComptes(String login,String password ) throws SQLException, ClassNotFoundException {
                    if (connexion.conn.isClosed())
                    {
                        connexion = new Connexion();
                    }

                    String reqInsert = "insert into compte (login,password) " + "values(?,?)";

                    try {
                        PreparedStatement pstmt = connexion.conn.prepareStatement(reqInsert);
                        pstmt.setString(1, login);
                        pstmt.setString(2, password);
                        pstmt.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println("Problème");
                        e.printStackTrace();
                    } finally {
                        if (connexion.conn != null) {
                            try {

                                connexion.conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                // throw new RuntimeException(e);
                            }

                        }

                    }
                }
    public  void ModifierComptes(int id,String login,String password ) throws SQLException, ClassNotFoundException {
        if (connexion.conn.isClosed())
        {
            connexion = new Connexion();
        }

        String reqInsert = "update compte set login = ? , password = ? where id_compte = ?";

        try {
            PreparedStatement pstmt = connexion.conn.prepareStatement(reqInsert);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problème");
            e.printStackTrace();
        } finally {
            if (connexion.conn != null) {
                try {

                    connexion.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // throw new RuntimeException(e);
                }

            }

        }
    }
    public  void SupprierCompte(int id ) throws SQLException, ClassNotFoundException {
        if (connexion.conn.isClosed())
        {
            connexion = new Connexion();
        }

        String reqInsert = "delete from compte where id_compte = ?";

        try {
            PreparedStatement pstmt = connexion.conn.prepareStatement(reqInsert);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problème");
            e.printStackTrace();
        } finally {
            if (connexion.conn != null) {
                try {

                    connexion.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // throw new RuntimeException(e);
                }

            }

        }
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CompteDAO c1 = new CompteDAO();

        for (Compte comptes : c1.afficherCompteDao()){
            System.out.println(comptes.toString());
            }
        c1.SupprierCompte(4);

        }
    }


