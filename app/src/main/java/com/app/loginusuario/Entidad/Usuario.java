package com.app.loginusuario.Entidad;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String nomUser;
    private String contrasenia;
    private int edad;
    private String correo;
    private String celular;

    public Usuario() {
    }

    public Usuario(String dni, String nombres, String apellidos, String nomUser, String contrasenia, int edad, String correo, String celular) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nomUser = nomUser;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.correo = correo;
        this.celular = celular;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + "\nNombre: " + getNombres()
                + "\nApelldios: " + getApellidos();
    }
}
