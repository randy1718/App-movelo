package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

 /*
    Estas son pruebas de integracion, por lo que se procura que todas funcionen como se supondria que deberia ser, es decir
    que no habra fallos. En las pruebas del sistema se realizaran pruebas similares pero que tiendan ahi si a fallar.
  */

class SinglentonTest {

    @Test
    void registroBiciusuario() {
        String nombre="Randy Rojas";
        String email="rrandymiller@gmail.com";
        String password="Randy123&a";
        Singlenton nuevo=Singlenton.laConstructora();
        String respuesta=nuevo.registroBiciusuario(nombre,email,password);
        assertEquals("Registrado correctamente!",respuesta);
    }

    @Test
    void ingreso() {
        String email="rrandymiller@gmail.com";
        String password="Randy123&a";
        Singlenton nuevo=Singlenton.laConstructora();
        String respuesta=nuevo.ingresar(email,password);
        assertEquals("Biciusuario",respuesta);
    }

    @Test
    void registroEmpresa() {
        Singlenton nuevo=Singlenton.laConstructora();
    }

    @Test
    void guardarRuta() {
        Singlenton nuevo=Singlenton.laConstructora();
        String email="rrandymiller@gmail.com";
        ArrayList<Punto> coordenadas=new ArrayList<>();
        coordenadas.add(new Punto(4.4574453,-72.85843));
        coordenadas.add(new Punto(4.4512453,-72.93343));
        Ruta r = new Ruta(coordenadas);
        Ruta r2 = new Ruta(coordenadas);
        Ruta r3 = new Ruta(coordenadas);
        String respuesta = nuevo.guardarRuta(r, email);
        String respuesta1 = nuevo.guardarRuta(r2, email);
        nuevo.guardarRuta(r3,email);
        ArrayList<Ruta> rutas=nuevo.getRutas(email);
        for(int i=0;i<rutas.size();i++){
            System.out.println(rutas.get(i).getDate());
        }
        assertEquals("ruta añadida correctamente",respuesta1);
    }

    @Test
    void agregarPuntos() {
        Singlenton nuevo=Singlenton.laConstructora();
        Double distanciaRecorrida=14.5;
        String email="rrandymiller@gmail.com";
        int puntos = Integer.parseInt(String.valueOf(Math.round(distanciaRecorrida * 10)));
        String respuesta=nuevo.agregarPuntos(puntos, email);
        assertEquals("Se añadieron 145 puntos correctamente! GOOD JOB!",respuesta);
    }

    @Test
    void comprarArbol() {
        Singlenton nuevo=Singlenton.laConstructora();
        String nameArbol="Arbol radiata";
        int points=20;
        Double huellaCarbono=34.5;
        String email="rrandymiller@gmail.com";
        Arbol tree=new Arbol(nameArbol,points,huellaCarbono);
        String respuesta=nuevo.comprarArbol(tree,points,email);
        assertEquals("Se añadio correctamente el arbol: Arbol radiata",respuesta);
    }

    @Test
    void darArboles() {

        Singlenton nuevo=Singlenton.laConstructora();
        String nameArbol="Arbol radiata";
        int points=20;
        Double huellaCarbono=34.5;
        String email="rrandymiller@gmail.com";
        Arbol tree=new Arbol(nameArbol,points,huellaCarbono);
        nuevo.comprarArbol(tree,points,email);
        String respuesta=nuevo.darArboles(email);
        assertEquals("1",respuesta);
    }

    @Test
    void darHuellaCarbono() {
        Singlenton nuevo=Singlenton.laConstructora();
        String nombre="Randy Miller";
        String email="rrandyrodi@gmail.com";
        String password="Randy123&a";
        nuevo.registroBiciusuario(nombre,email,password);
        nuevo.ingresar(email,password);
        Double distanciaRecorrida=14.5;
        int puntos = Integer.parseInt(String.valueOf(Math.round(distanciaRecorrida * 10)));
        nuevo.agregarPuntos(puntos, email);
        String nameArbol="Arbol radiata";
        int points=20;
        Double huellaCarbono=34.5;
        Arbol tree=new Arbol(nameArbol,points,huellaCarbono);
        nuevo.comprarArbol(tree,points,email);
        String respuesta=nuevo.darHuellaCarbono(email);
        assertEquals("34.5",respuesta);
    }

    @Test
    void darPuntos() {
        Singlenton nuevo=Singlenton.laConstructora();
        String email="rrandymiller@gmail.com";
        String respuesta=nuevo.darPuntos(email);
        assertEquals("125",respuesta);
    }


    @Test
    void darNombreUsuario() {
        Singlenton nuevo=Singlenton.laConstructora();
        String email="rrandymiller@gmail.com";
        String respuesta=nuevo.darNombreUsuario(email);
        assertEquals("Randy Rojas",respuesta);
    }

}