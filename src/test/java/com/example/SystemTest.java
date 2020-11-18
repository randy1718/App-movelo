package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class SystemTest {

    @Test
    void prueba(){
        Singlenton nuevo=Singlenton.laConstructora();
        String signup=nuevo.registroBiciusuario("Juan","juan@gmail.com","juan123&as");
        assertEquals("Registrado correctamente!",signup);
    }

    @Test
    void Ingreso(){
        Singlenton nuevo=Singlenton.laConstructora();
        String login=nuevo.ingresar("juangmail.com","juan123&as");
        assertEquals("Biciusuario",login);

    }

    @Test
    void Ruta(){
        Singlenton nuevo=Singlenton.laConstructora();
        String saveroute=nuevo.guardarRuta(new Ruta(new ArrayList<Punto>()),"juangmail.com");
        assertEquals("ruta añadida correctamente",saveroute);
    }

    @Test
    void Puntos(){
        Singlenton nuevo=Singlenton.laConstructora();
        String addPoints=nuevo.agregarPuntos(0123,"juangmail.com");
        assertEquals("Se añadieron 123 puntos correctamente! GOOD JOB!",addPoints);
        String getPoints=nuevo.darPuntos("juangmail.com");
        assertEquals("123",getPoints);
    }

    @Test
    void Arbol(){
        Singlenton nuevo=Singlenton.laConstructora();
        String plantTree=nuevo.comprarArbol(new Arbol("Pino",2000,0.5),1000,"juangmail.com");
        assertEquals("Se añadio correctamente el arbol: Pino",plantTree);
        String getTrees=nuevo.darArboles("juangmail.com");
        assertEquals("1",getTrees);
    }

    @Test
    void HuellaCarbono(){
        Singlenton nuevo=Singlenton.laConstructora();
        String getCarbonFootprint=nuevo.darHuellaCarbono("juangmail.com");
        assertEquals("0.5",getCarbonFootprint);
    }

}
