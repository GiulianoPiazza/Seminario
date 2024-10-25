package clases;

//La clase "Paciente" representa a un paciente con atributos como * nombre, ID, nivel de urgencia
// y método para mostrar información del paciente.


// Clase "Paciente" extiende la clase "Usuario"
public class Paciente extends Usuario {

    // Atributo para el nivel de urgencia del paciente
    private int nivelUrgencia; // 1 (emergencia), 2(Urgencia) o 3(Patología Común)

    // Constructor que inicializa el paciente con su nivel de urgencia
    public Paciente(int dni, String nombre, String apellido, int nivelUrgencia) {
        super(dni, nombre, apellido); // Se llama al constructor de Usuario
        this.nivelUrgencia = nivelUrgencia;
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

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    // Método que muestra la información del paciente
    public void mostrarInfo() {
        System.out.println(
                "Paciente: " + nombre + " " + apellido + ", DNI: " + dni + ", Nivel de Urgencia: " + nivelUrgencia);
    }
}
