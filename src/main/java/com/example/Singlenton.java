package com.example;


import java.util.ArrayList;

public class Singlenton {

    private ArrayList<Stakeholder> miembros=new ArrayList<>();

    private static Singlenton instancia = null;

    public static Singlenton laConstructora(){

        if(instancia==null){
            instancia=new Singlenton();
        }
        return instancia;
    }

    public String ingresar(String email, String password){
        String respuesta="No access";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (email.equals(miembros.get(i).getEmail()) && password.equals(miembros.get(i).getPassword())) {
                    respuesta="Biciusuario";
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (email.equals(miembros.get(i).getEmail()) && password.equals(miembros.get(i).getPassword())) {
                    respuesta="Empresa";
                }
            }
        }
        return respuesta;
    }

    public String registroBiciusuario(String nombre,String email,String password) {
        String answer="Registro fallido";

        int contador=0;
        for(int i=0;i<miembros.size();i++){
             if(email.equals(miembros.get(i).getEmail()) || nombre.equals(miembros.get(i).getNombre())){
                answer="El biciusuario ya existe!";
            }else{
                contador++;
            }
        }

        if(contador==miembros.size()){
            Stakeholder biciusuario=new Biciusuario(nombre,email,password);
            miembros.add(biciusuario);
            for(int i=0;i<miembros.size();i++){
                if(email.equals(miembros.get(i).getEmail()) || nombre.equals(miembros.get(i).getNombre())){
                    answer="Registrado correctamente!";
                }else{
                    answer="La contraseña o el correo estan incorrectos!";
                }
            }
            
        }

        return answer;
    }
}
