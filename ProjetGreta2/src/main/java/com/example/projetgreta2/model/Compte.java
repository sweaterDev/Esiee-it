package com.example.projetgreta2.model;


public class Compte {
    protected String login;
    protected  String password;
    protected int id;

    @Override
    public String toString() {
        return "compte{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Compte(){
        login = null;
        password = null;
        id = 0;
    }
}
