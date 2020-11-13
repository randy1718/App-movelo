package com.example;

import javax.swing.*;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Biciusuario extends Stakeholder{

    private int puntos;
    private double huellaCarbono;
    private ArrayList<Ruta> rutas;
    private ArrayList<Arbol> arboles;
    private String name,correo,clave;
    private String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
            + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
            + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
    public Biciusuario(String nombre,String email,String password){
        try {
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(password);
            int mayusculas = verificarMayusculas(password);
            int arroba=verificarCorreo(email);
            int numeros=verificarNumeros(password);


            if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1 && !email.isEmpty() && !nombre.isEmpty()) {
                name = nombre;
                correo = email;
                clave = password;
                rutas=new ArrayList<>();
                arboles=new ArrayList<>();
                System.out.println("creando biciusuario...");
            }else{
                JPanel panel=new JPanel();
                JOptionPane.showMessageDialog(panel,"El biciusuario "+nombre+" tiene la contraseña o el correo invalidos","Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){

        }

    }

    public void agregarPuntos(int points){
        puntos+=points;
    }

    public int getPuntos(){
        return puntos;
    }

    public void disminuirPuntos(int points){
        puntos-=points;
    }

    public void addArbol(Arbol tree){
        arboles.add(tree);
    }

    public ArrayList<Arbol> getArboles() {
        return arboles;
    }

    public double getHuellaCarbono(){
        double huella=0.0;
        for(int i=0;i<arboles.size();i++){
            huella+=arboles.get(i).getHuellaCarbono();
        }
        return huella;
    }

    public void addRuta(Ruta ruta){
        rutas.add(ruta);
    }

    @Override
    public String mostrarDatos() {
        return "Datos Biciusuario: \n"+"Nombre: "+name+"\nEmail: "+correo+"\n\n";
    }

    @Override
    public void setNombre(String name) {
        if(!name.equals("")){
            this.name=name;
        }else{
            System.out.println("El username nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setEmail(String email) {
        if(!correo.equals("")){
            int arroba=verificarCorreo(email);
            if(arroba==1){
                correo=email;
            }
        }else{
            System.out.println("El email nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setPassword(String password) {
        if(!password.equals("")){
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(clave);
            int mayusculas = verificarMayusculas(clave);
            if(password.length()>=8 && matcher.find() && mayusculas>=1 ){
                clave=password;
            }
        }else{
            System.out.println("La clave nueva no puede estar vacia!");
        }
    }

    @Override
    public String getNombre() {
        return name;
    }

    @Override
    public String getEmail() {
        return correo;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public int verificarMayusculas(String clave) {
        int contador = 0;
        char letra;
        for (int i = 0; i < clave.length(); i++) {
            letra = clave.charAt(i);
            if (Character.isUpperCase(letra)) {
                contador = contador + 1;
            }
        }

        return contador;
    }

    @Override
    public int verificarCorreo(String correo) {
        int contador = 0;
        char letra;
        for (int i = 0; i < correo.length(); i++) {
            letra = correo.charAt(i);
            String let=String.valueOf(letra);
            if (let.equals("@")) {
                contador = contador + 1;
            }
        }

        return contador;
    }

    @Override
    public int verificarNumeros(String clave) {
        int contador = 0;
        char letra;
        for (int i = 0; i < clave.length(); i++) {
            letra = clave.charAt(i);
            String let=String.valueOf(letra);
            if (let.matches("[0-9]")) {
                contador = contador + 1;
            }
        }

        return contador;
    }
}
