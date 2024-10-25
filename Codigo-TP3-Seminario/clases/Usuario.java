package clases;

//La clase `Usuario` es una clase abstracta con atributos para DNI, nombre y apellido, junto con
//métodos para obtener y establecer dichos atributos, y un método abstracto para mostrar información.


public abstract class Usuario {
    // Atributos protegidos de la clase Usuario
    protected int dni;
    protected String nombre;
    protected String apellido;

    // Constructor que inicializa el DNI, nombre y apellido del usuario
    public Usuario(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método abstracto que van a ser implementadas por las clases hijas
    public abstract void mostrarInfo();
}
