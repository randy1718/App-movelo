package com.example;

import java.util.ArrayList;

public class Ruta {

    private ArrayList<Punto> coordenadas;

    public Ruta(ArrayList<Punto> coordenadas){
        this.coordenadas=coordenadas;
    }

    public ArrayList<Punto> getCoordenadas(){
        return coordenadas;
    }

}
