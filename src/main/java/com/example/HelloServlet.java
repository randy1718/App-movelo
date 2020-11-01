package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

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


    public static void main(String[] args) {
        SpringApplication.run(HelloServlet.class, args);
    }
    
}
