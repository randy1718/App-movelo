package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AceptationTest {

    @Test
    void PruebaTotal(){
        Singlenton nuevo=Singlenton.laConstructora();
        String signup=nuevo.registroBiciusuario("Manuel","manuel@gmail.com","MA18&NU13el");
        assertEquals("Registrado correctamente!",signup);
        String login=nuevo.ingresar("manuel@gmail.com","MA18&NU13el");
        assertEquals("Biciusuario",login);
        String saveroute=nuevo.guardarRuta(new Ruta(new ArrayList<Punto>()),"manuel@gmail.com");
        assertEquals("ruta añadida correctamente",saveroute);
        String addPoints=nuevo.agregarPuntos(123,"manuel@gmail.com");
        assertEquals("Se añadieron 123 puntos correctamente! GOOD JOB!",addPoints);
        String getPoints=nuevo.darPuntos("manuel@gmail.com");
        assertEquals("123",getPoints);
        String plantTree=nuevo.comprarArbol(new Arbol("Pino",2000,0.5),1000,"manuel@gmail.com");
        assertEquals("Se añadio correctamente el arbol: Pino",plantTree);
        String getTrees=nuevo.darArboles("manuel@gmail.com");
        assertEquals("1",getTrees);
        String getCarbonFootprint=nuevo.darHuellaCarbono("manuel@gmail.com");
        assertEquals("0.5",getCarbonFootprint);
    }

}
