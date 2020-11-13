package com.example;

public class Arbol {

    private String name;
    private int precio;
    private Double huellaCarbono;

    public Arbol(String name, int precio, Double huellaCarbono){
        this.name=name;
        this.precio=precio;
        this.huellaCarbono=huellaCarbono;
    }

    public String getName(){
        return name;
    }

    public Double getHuellaCarbono(){
        return huellaCarbono;
    }

}
