// La clase `Administrador` hereda de `Usuario` y representa a un administrador del sistema.
// A diferencia de `Paciente` y `Medico`, `Administrador` no tiene atributos adicionales.

package model;

public class Administrador extends Usuario {

    // Constructor que inicializa un `Administrador` con su dni, nombre y apellido.
    // Utiliza el constructor de `Usuario` para inicializar los atributos heredados.
    public Administrador(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    // Implementación del método `mostrarInfo`, que muestra la información del administrador en la consola.
    @Override
    public void mostrarInfo() {
        System.out.println("Administrador: " + nombre + " " + apellido + ", DNI: " + dni);
    }
}
