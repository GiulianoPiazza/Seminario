// La clase `Medico` hereda de `Usuario` y representa a un médico con detalles adicionales de especialidad y matrícula.
// Esta clase incluye métodos para obtener y establecer sus atributos específicos.

package model;

public class Medico extends Usuario {
    
    // Atributos específicos de un médico
    private int especialidadId;
    private String matricula;

    // Constructor que inicializa un `Medico` con su dni, nombre, apellido, especialidad y matrícula.
    // Utiliza el constructor de `Usuario` para inicializar los atributos heredados.
    public Medico(int dni, String nombre, String apellido, int especialidadId, String matricula) {
        super(dni, nombre, apellido);
        this.especialidadId = especialidadId;
        this.matricula = matricula;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Implementación del método `mostrarInfo`, que muestra la información del médico en la consola.
    @Override
    public void mostrarInfo() {
        System.out.println("Médico: " + nombre + " " + apellido + ", DNI: " + dni + ", Especialidad ID: "
                + especialidadId + ", Matrícula: " + matricula);
    }
}
