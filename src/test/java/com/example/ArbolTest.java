package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolTest {

    @Test
    void Arbol() {
        String name="Pino";
        int puntos=12;
        Double huellaCarbono=45.0;
        Arbol tree=new Arbol(name,puntos,huellaCarbono);
        assertEquals("Pino45.0",tree.getName()+tree.getHuellaCarbono());
    }
}