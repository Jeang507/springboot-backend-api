package com.jean.backend.springbootbackend.model;

/**
 * Modelo que representa a un estudiante.
 */
public class Student {

    /** Identificador del estudiante */
    private int id;

    /** Nombre del estudiante */
    private String name;

    /** Correo electrónico del estudiante */
    private String email;

    /** Edad del estudiante */
    private Integer age;

    /** Curso del estudiante */
    private String course;

    /**
     * Constructor vacío.
     * Necesario para la deserialización de JSON.
     */
    public Student(){
    }

    /**
     * Constructor con todos los atributos.
     * @param id identificador del estudiante
     * @param name nombre del estudiante
     * @param email correo electrónico
     * @param age edad del estudiante
     * @param course curso del estudiante
     */
    public Student(int id, String name, String email, Integer age, String course){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
    }

    /**
     * Devuelve el id del estudiante.
     * @return id del estudiante
     */
    public int getId(){
        return id;
    }

    /**
     * Asigna el id del estudiante.
     * @param id id del estudiante
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Devuelve el nombre del estudiante.
     * @return nombre del estudiante
     */
    public String getName(){
        return name;
    }

    /**
     * Asigna el nombre del estudiante.
     * @param name nombre del estudiante
     */
    public void setName(String name){
        this.name = name; 
    }

    /**
     * Devuelve el correo electrónico del estudiante.
     * @return correo electrónico
     */
    public String getEmail(){
        return email;
    }

    /**
     * Asigna el correo electrónico del estudiante.
     * @param email correo electrónico
     */
    public void setEmail(String email){
        this.email = email; 
    }

    /**
     * Devuelve la edad del estudiante.
     * @return edad del estudiante
     */
    public Integer getAge(){
        return age;
    }

    /**
     * Asigna la edad del estudiante.
     * @param age edad del estudiante
     */
    public void setAge(Integer age){
        this.age = age;
    }

    /**
     * Devuelve el curso del estudiante.
     * @return curso del estudiante
     */
    public String getCourse(){
        return course;
    }

    /**
     * Asigna el curso del estudiante.
     * @param course curso del estudiante
     */
    public void setCourse(String course){
        this.course = course; 
    }
}
