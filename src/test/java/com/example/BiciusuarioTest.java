package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class BiciusuarioTest {

    @Test
    void crearBiciusuario() {
        String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AErqw12$#");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(password);
        int mayusculas = user.verificarMayusculas(password);
        int arroba=user.verificarCorreo(email);
        int numeros=user.verificarNumeros(password);
        if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1){
            assertEquals("Juan josejose@gmail.comAErqw12$#",nombre+email+password);
        }else{
            fail("La clave o el correo no cumplen con los requerimientos!");
        }

    }

    @Test
    void agregarPuntos() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        user.agregarPuntos(145);
        String res=String.valueOf(user.getPuntos());
        assertEquals("145",res);
    }


    @Test
    void disminuirPuntos() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        user.agregarPuntos(145);
        String res=String.valueOf(user.getPuntos());
        assertEquals("145",res);
        user.disminuirPuntos(50);
        String respuesta=String.valueOf(user.getPuntos());
        assertEquals("95",respuesta);

    }

    @Test
    void addArbol() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        Arbol tree=new Arbol("Pino",50,12.4);
        user.addArbol(tree);
        Arbol arbol=user.getArbol("Pino");
        assertEquals("Pino12.4",arbol.getName()+arbol.getHuellaCarbono());
    }

    @Test
    void getHuellaCarbono() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        Arbol tree=new Arbol("Pino",50,12.4);
        user.addArbol(tree);
        Arbol treee=new Arbol("El trento",100,100.4);
        user.addArbol(treee);
        assertEquals("113",""+Math.round(user.getHuellaCarbono()));
    }

    @Test
    void addRuta() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        ArrayList<Punto> coordenadas=new ArrayList<>();
        coordenadas.add(new Punto(4.4574453,-72.85843));
        coordenadas.add(new Punto(4.4512453,-72.93343));
        Ruta r = new Ruta(coordenadas);
        user.addRuta(r);
        ArrayList<Ruta> rutas=user.getRutas();
        assertEquals(r.getCode(),rutas.get(0).getCode());
    }


    @Test
    void mostrarDatos() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        String datos=user.mostrarDatos();
        assertEquals("Datos Biciusuario: \nNombre: Juan jose\nEmail: jose@gmail.com\n\n",datos);
    }

    @Test
    void setNombre() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        user.setNombre("JUAN JOSE");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        assertEquals("JUAN JOSEjose@gmail.comAERqw12$#",nombre+email+password);
    }

    @Test
    void setEmail() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        user.setEmail("jjose@gmail.com");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        assertEquals("Juan josejjose@gmail.comAERqw12$#",nombre+email+password);
    }

    @Test
    void setPassword() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#");
        user.setPassword("1234AS!%");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        assertEquals("Juan josejose@gmail.com1234AS!%",nombre+email+password);
    }

}