package model;

//La clase Especialidad representa una especialidad médica dentro del sistema, 
//como "Medicina General", "Pediatría", "Cardiología", etc. Cada especialidad tiene 
//un ID único, un nombre, y una descripción. Estos atributos permiten categorizar las 
//diferentes especialidades disponibles en la clínica, facilitando la asignación de 
//pacientes y médicos según las áreas de atención.

// Atributos de la especialidad
public class Especialidad {
    private int idEspecialidad;
    private String nombre;
    private String descripcion;

    // Constructor para inicializar los valores de la especialidad
    public Especialidad(int idEspecialidad, String nombre, String descripcion) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
