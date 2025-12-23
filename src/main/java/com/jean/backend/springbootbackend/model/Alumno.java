package com.jean.backend.springbootbackend.model;

public class Alumno {

    //Atributos
    private int id;
    private String nombre;
    private String email;
    private Integer edad;
    private String curso;

    //Constructor vacío
    public Alumno(){
    }

    //Constructor con parámetros
    public Alumno (int id, String nombre, String email, Integer edad, String curso){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.curso = curso;
    }

    //Getter y Setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email; 
    }

    public Integer getEdad(){
        return edad;
    }

    public void setEdad(Integer edad){
        this.edad = edad;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso; 
    }
}
