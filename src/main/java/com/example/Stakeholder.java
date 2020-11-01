package launch;

public abstract class Stakeholder {

    abstract public String mostrarDatos();
    abstract public void setNombre(String name);
    abstract public void setEmail(String email);
    abstract public void setPassword(String password);
    abstract public String getNombre();
    abstract public String getEmail();
    abstract public String getPassword();
    abstract public int verificarMayusculas(String clave);
    abstract public int verificarCorreo(String email);
    abstract public int verificarNumeros(String clave);

}
