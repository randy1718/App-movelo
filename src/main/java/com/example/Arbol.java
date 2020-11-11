package com.example;

public class Arbol {

    private String name;
    private int precio;
    private String huellaCarbono;

    public Arbol(String name, int precio, String huellaCarbono){
        this.name=name;
        this.precio=precio;
        this.huellaCarbono=huellaCarbono;
    }

    public String getName(){
        return name;
    }

}
