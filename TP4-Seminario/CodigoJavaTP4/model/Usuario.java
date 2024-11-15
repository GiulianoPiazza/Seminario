// La clase `Usuario` es una clase abstracta que representa los atributos y comportamientos básicos de un usuario.
// Al ser abstracta, no se puede instanciar directamente; está pensada para que otras clases la hereden.
// Esta clase define atributos comunes (dni, nombre, apellido) y métodos generales para manejar estos datos.


package model;

public abstract class Usuario {
    // Atributos protegidos para que las clases que heredan puedan acceder a ellos.
    protected int dni;
    protected String nombre;
    protected String apellido;

     // Constructor de la clase `Usuario`, permite inicializar un usuario con su dni, nombre y apellido.
    public Usuario(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

     // Métodos getters que permiten acceder a los atributos de un `Usuario`.
    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    // Método abstracto `mostrarInfo` que deben implementar las clases que heredan de `Usuario`.
    public abstract void mostrarInfo();
}
