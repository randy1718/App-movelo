package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SpringBootApplication

public class HelloServlet{

    @RequestMapping(value="/registerBiciusuario",method = RequestMethod.POST)
    @ResponseBody
    String registroBiciusuario(String nombre,String email,String password, String conPassword){
        String respuesta="";
        Singlenton nuevo=Singlenton.laConstructora();
        if(email.equals("") || password.equals("")){
            respuesta= "No se ingresaron los datos!...";
        }else if(!password.equals(conPassword)) {
            respuesta="Las contraseñas no coinciden";
        }else{
            respuesta=nuevo.registroBiciusuario(nombre,email,password);
        }
        return respuesta;
    }

    @RequestMapping(value="/ingreso",method = RequestMethod.POST)
    @ResponseBody
    String ingreso(String email,String password){
        String respuesta="no existe";
        Singlenton nuevo=Singlenton.laConstructora();
        if(email.equals("") || password.equals("")){
            respuesta= "No se ingresaron los datos";
        }else{
            respuesta=nuevo.ingresar(email, password);
        }
        return respuesta;
    }

    @RequestMapping(value="/RegistroEmpresa",method = RequestMethod.POST)
    @ResponseBody

    String registroEmpresa(){
        return "";
    }

    @RequestMapping(value="/GuardarRuta",method = RequestMethod.POST)
    @ResponseBody

    String guardarRuta(ArrayList<Punto> ruta, String email){
        String respuesta="No se guardo...";

        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            Ruta r = new Ruta(ruta);
            respuesta = nuevo.guardarRuta(r, email);
        }

        return respuesta;
    }

    @RequestMapping(value="/AgregarPuntos",method = RequestMethod.POST)
    @ResponseBody

    String agregarPuntos(Double distanciaRecorrida,String email){
        String respuesta="Algo falloooo";
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            int puntos = Integer.parseInt(String.valueOf(Math.round(distanciaRecorrida * 10)));
            respuesta=nuevo.agregarPuntos(puntos, email);
        }
        return respuesta;
    }

    @RequestMapping(value="/ComprarArbol",method = RequestMethod.POST)
    @ResponseBody

    String comprarArbol(String nameArbol,Double huellaCarbono, int points, String email){
        String respuesta="Failed...";
        Arbol tree=new Arbol(nameArbol,points,huellaCarbono);
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            respuesta=nuevo.comprarArbol(tree,points,email);
        }
        return respuesta;
    }

    @RequestMapping(value="/DarPuntos",method = RequestMethod.POST)
    @ResponseBody

    String darPuntos(String email){
        String respuesta="Failed...";
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            respuesta=nuevo.darPuntos(email);
        }
        return respuesta;
    }

    @RequestMapping(value="/DarArboles",method = RequestMethod.POST)
    @ResponseBody

    String darArboles(String email){
        String respuesta="Failed...";
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            respuesta=nuevo.darArboles(email);
        }
        return respuesta;
    }

    @RequestMapping(value="/DarHuellaCarbono",method = RequestMethod.POST)
    @ResponseBody

    String darHuellaCarbono(String email){
        String respuesta="Failed...";
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            respuesta=nuevo.darHuellaCarbono(email);
        }
        return respuesta;
    }

    @RequestMapping(value="/DarNombreUsuario",method = RequestMethod.POST)
    @ResponseBody

    String darNombreUsuario(String email){
        String respuesta="Failed...";
        Singlenton nuevo=Singlenton.laConstructora();
        if(!email.isEmpty()) {
            respuesta=nuevo.darNombreUsuario(email);
        }
        return respuesta;
    }


    public static void main(String[] args) {
        SpringApplication.run(HelloServlet.class, args);
    }
    
}
