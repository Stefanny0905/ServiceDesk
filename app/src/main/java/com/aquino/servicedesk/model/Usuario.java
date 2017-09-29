package com.aquino.servicedesk.model;


public class Usuario {


    private String username;
    private String password;
    private String nombres;
    private int rol;

    public Usuario(){}

    public Usuario(String username, String password, String nombres, int rol) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
