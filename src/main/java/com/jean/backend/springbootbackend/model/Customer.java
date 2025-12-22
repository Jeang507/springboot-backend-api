package com.jean.backend.springbootbackend.model;

/**
 * Modelo: Clase que inicializa los atributos, getters y setters
 */
public class Customer {

    //Atributos
    private int ID;
    private String name;
    private String userName;
    private String password;

    //Constructor vacío
    public Customer(){}

    //Constructor con parámetros
    public Customer(int ID, String name, String userName, String password){
        this.ID = ID;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    //Getter y Setters
    public int getId(){
        return ID;
    }

    public void setId(int ID){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
