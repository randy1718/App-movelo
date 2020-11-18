package com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Ruta {

    private ArrayList<Punto> coordenadas;
    private int code;
    private String date;
    private SimpleDateFormat formatter;

    public Ruta(ArrayList<Punto> coordenadas){
        Random rtm=new Random();
        int code=rtm.nextInt(500)+1;
        this.coordenadas=coordenadas;
        this.code=code;
        Date datetime=new Date();
        formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        date=formatter.format(datetime);
    }

    public ArrayList<Punto> getCoordenadas(){
        return coordenadas;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int codigo){
        code=codigo;
    }

    public String getDate(){
        return date;
    }

}
