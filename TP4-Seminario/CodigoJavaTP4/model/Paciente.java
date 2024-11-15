// La clase `Paciente` hereda de `Usuario` y representa a un paciente de la clínica con información adicional.
// Además de los atributos de `Usuario`, añade datos específicos como teléfono, email, especialidad y código único.


package model;

// Atributos específicos de un paciente
public class Paciente extends Usuario {
    private String telefono;
    private String email;
    private int especialidadId;
    private String codigoUnico;
    private int nivelUrgencia;

    // Constructor que inicializa un `Paciente` con su dni, nombre, apellido, teléfono, email, especialidad y código único.
    // Se llama al constructor de la clase `Usuario` usando `super`.
    public Paciente(int dni, String nombre, String apellido, String telefono, String email, int especialidadId, String codigoUnico) {
        super(dni, nombre, apellido);
        this.telefono = telefono;
        this.email = email;
        this.especialidadId = especialidadId;
        this.codigoUnico = codigoUnico;
    }

    // Getters y Setters
    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;  // Evitar la recursión infinita
    }

    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

     // Implementación del método `mostrarInfo`, sobrescribiendo el método abstracto de `Usuario`.
    // Muestra la información del paciente de forma detallada en la consola.
    @Override
        public void mostrarInfo() {
            System.out.println("Paciente: " + nombre + " " + apellido + ", DNI: " + dni + ", Teléfono: " + telefono + ", Email: " + email + ", Especialidad ID: " + especialidadId);
        }
        
}
