
//La clase "Main" representa un sistema para gestionar Turnos en la clínica sanitaria CBA, con
//distintas funcionalidades para pacientes, médicos y administradores.

import clases.*;
import servicios.*;
import funcionesUtiles.FuncionesDeEntradas;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Se inicializan los servicios y listas
    private static ListaTurnos listaTurnos = new ListaTurnos();
    private static PacienteServicio pacienteServicio = new PacienteServicio(listaTurnos);
    private static MedicoServicio medicoServicio = new MedicoServicio();
    private static AdministradorServicio administradorServicio = new AdministradorServicio(medicoServicio);
    private static List<Especialidad> especialidades = inicializarEspecialidades();

    // Método principal que gestiona el ciclo de vida del programa
    public static void main(String[] args) {
        // Se ingresan algunos médicos y administradores predefinidos
        inicializarDatos();
        // Bucle principal del menú
        while (true) {
            System.out.println("============================================================================");
            System.out.println("============ SISTEMA DE GESTIÓN DE TURNOS CLÍNICA SANITARIA CBA ============");
            System.out.println("============================================================================");
            System.out.println("------------                 Seleccione su rol:                 ------------");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("--    1. Paciente                                                         --");
            System.out.println("--    2. Médico                                                           --");
            System.out.println("--    3. Administrador                                                    --");
            System.out.println("--    4. Salir                                                            --");
            System.out.println("----------------------------------------------------------------------------");

            System.out.print("Opción: ");
            try {
                int opcion = FuncionesDeEntradas.leerInt(); // Se lee opción del usuario

                // Lógica del menú según Paciente, Medico o Administrador
                switch (opcion) {
                    case 1:
                        menuPaciente();
                        break;
                    case 2:
                        menuMedico();
                        break;
                    case 3:
                        menuAdministrador();
                        break;
                    case 4:
                        System.out.println(
                                "============================================================================");
                        System.out.println(
                                "==   Saliendo del sistema. ¡¡¡Gracias por ser parte de la clinica cba!!!  ==");
                        System.out.println(
                                "============================================================================");
                        System.exit(0); // Termina el programa
                    default:
                        System.out.println("Opción inválida. Vuelva a intentar.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            }
        }
    }

    // Método para inicializar las especialidades disponibles en la clínica
    private static List<Especialidad> inicializarEspecialidades() {
        List<Especialidad> lista = new ArrayList<>();
        lista.add(new Especialidad(1, "Medicina General", "Atención primaria."));
        lista.add(new Especialidad(2, "Pediatría", "Atención a niños."));
        lista.add(new Especialidad(3, "Ginecología", "Salud femenina."));
        lista.add(new Especialidad(4, "Cardiología", "Enfermedades del corazón."));
        lista.add(new Especialidad(5, "Dermatología", "Enfermedades de la piel."));
        lista.add(new Especialidad(6, "Oncología", "Tratamiento del cáncer."));
        lista.add(new Especialidad(7, "Gastroenterología", "Enfermedades del sistema digestivo."));
        lista.add(new Especialidad(8, "Urología", "Salud del tracto urinario."));
        return lista;
    }

    // Método para inicializar los datos de médicos y administradores predefinidos
    private static void inicializarDatos() {
        // Medicos agregados de cada especialidad
        medicoServicio.agregarMedico(new Medico(11, "Giuliano", "Piazza", "Medicina General"));
        medicoServicio.agregarMedico(new Medico(21, "Rolando", "Piazza", "Pediatría"));
        medicoServicio.agregarMedico(new Medico(31, "Laura", "Raniti", "Ginecología"));
        medicoServicio.agregarMedico(new Medico(41, "Fiamma", "Brunori", "Cardiología"));
        medicoServicio.agregarMedico(new Medico(51, "Agustin", "Urenda", "Dermatología"));
        medicoServicio.agregarMedico(new Medico(61, "Elias", "Gonzales", "Oncología"));
        medicoServicio.agregarMedico(new Medico(71, "Ignacio", "Gomez", "Gastroenterología"));
        medicoServicio.agregarMedico(new Medico(81, "Armando", "Perez", "Urología"));

        // 2 Administradores que manejan el sistema
        administradorServicio.agregarAdministrador(new Administrador(11, "Magdalena", "Merlo"));
        administradorServicio.agregarAdministrador(new Administrador(22, "Javier", "Gonzalez"));
    }

    // Menú para los pacientes
    private static void menuPaciente() {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("-----------------  Menú Paciente -----------------");
            System.out.println("--------------------------------------------------");
            System.out.println("--  1. Solicitar Turno                          --");
            System.out.println("--  2. Cancelar Turno                           --");
            System.out.println("--  3. Ver Pacientes en Espera                  --");
            System.out.println("--  4. Volver al Menú Principal                 --");
            System.out.println("--------------------------------------------------");
            System.out.print("Opción: ");
            try {
                int opcion = FuncionesDeEntradas.leerInt();

                switch (opcion) {
                    case 1:
                        solicitarTurno();
                        break;
                    case 2:
                        cancelarTurno();
                        break;
                    case 3:
                        verPacientesEnEspera();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentar.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            }
        }
    }

    // El paciente solicita un turno médico.
    // Se le pide que ingrese su DNI, nombre, apellido y el nivel de urgencia.
    // Luego, selecciona la especialidad y, dentro de esta, el médico que lo
    // atenderá.
    // Finalmente, el turno es registrado en el sistema.
    private static void solicitarTurno() {
        System.out.println("---------------------------------------------------");
        System.out.println("----------------- Solicitar Turno -----------------");
        System.out.println("---------------------------------------------------");

        try {
            System.out.print("-->> Ingresa tu DNI: ");
            int dni = FuncionesDeEntradas.leerInt();
            System.out.print("-->> Ingresa tu nombre: ");
            String nombre = FuncionesDeEntradas.leerString();
            System.out.print("-->> Ingresa tu apellido: ");
            String apellido = FuncionesDeEntradas.leerString();
            System.out.print("-->> Seleccione nivel de urgencia (1: Emergencia, 2: Urgencia, 3: Patología común): ");
            int nivel = FuncionesDeEntradas.leerInt();
            if (nivel < 1 || nivel > 3) {
                System.out.println("Nivel de urgencia inválido.");
                return; // Si el nivel es inválido, se detiene la operación.
            }

            // Se busca si el paciente ya está registrado en el sistema.
            Paciente paciente = pacienteServicio.buscarPaciente(dni);
            if (paciente == null) {
                // Si no está registrado, se crea un nuevo paciente y se añade a la lista de
                // pacientes.
                paciente = new Paciente(dni, nombre, apellido, nivel);
                pacienteServicio.agregarPaciente(paciente);
            }

            // Se muestran las especialidades disponibles para que el paciente seleccione
            // una.
            System.out.println("Seleccione la especialidad:");
            for (Especialidad e : especialidades) {
                System.out.println(e.getIdEspecialidad() + ". " + e.getNombre());
            }
            System.out.print("Opción: ");
            // Se busca la especialidad seleccionada por el paciente.
            int opcionEspecialidad = FuncionesDeEntradas.leerInt();
            Especialidad especialidadSeleccionada = null;
            for (Especialidad esp : especialidades) {
                if (esp.getIdEspecialidad() == opcionEspecialidad) {
                    especialidadSeleccionada = esp;
                    break;
                }
            }
            if (especialidadSeleccionada == null) {
                System.out.println("Especialidad inválida.");
                return;
            }

            // Se listan los médicos disponibles para la especialidad seleccionada.
            List<Medico> medicosDisponibles = new ArrayList<>();
            for (Medico med : medicoServicio.getMedicos()) {
                if (med.getEspecialidad().equalsIgnoreCase(especialidadSeleccionada.getNombre())) {
                    medicosDisponibles.add(med);
                }
            }
            if (medicosDisponibles.isEmpty()) {
                System.out.println("No hay médicos disponibles para esta especialidad.");
                return;
            }

            // El paciente selecciona el médico.
            System.out.println("Seleccione el Médico:");
            for (int i = 0; i < medicosDisponibles.size(); i++) {
                Medico med = medicosDisponibles.get(i);
                System.out.println(
                        (i + 1) + ". " + med.getNombre() + " " + med.getApellido() + " (DNI: " + med.getDni() + ")");
            }
            System.out.print("Opción: ");
            int opcionMedico = FuncionesDeEntradas.leerInt();
            if (opcionMedico < 1 || opcionMedico > medicosDisponibles.size()) {
                System.out.println("Médico inválido.");
                return;
            } 
            Medico medicoSeleccionado = medicosDisponibles.get(opcionMedico - 1);

            // Se solicita el turno y se registra en el sistema.
            pacienteServicio.solicitarTurno(paciente, medicoSeleccionado.getDni(), nivel);
        } catch (Exception e) {
            System.out.println("Error al solicitar el turno. Por favor, revise los datos ingresados.");
        }
    }

    // El paciente cancela su turno ingresando su código único.
    private static void cancelarTurno() {
        System.out.println("\n--- Cancelar Turno ---");
        System.out.print("Ingrese su código único de turno: ");
        String codigo = FuncionesDeEntradas.leerString();
        pacienteServicio.cancelarTurno(codigo);
    }

    // El paciente puede ver cuántos pacientes están en espera antes que él.
    private static void verPacientesEnEspera() {
        System.out.println("\n--- Ver Pacientes en Espera ---");
        System.out.print("Ingrese su código único de turno: ");
        String codigo = FuncionesDeEntradas.leerString();
        pacienteServicio.verTurnosEnEspera(codigo);
    }

    // Menú para los médicos donde pueden ver sus turnos y generar reportes diarios.
    private static void menuMedico() {
        System.out.println("\n--------------- Menú Médico ---------------");
        // Se solicita el DNI del médico para acceder a su cuenta.
        System.out.print("Ingrese su DNI (11, 21, 31 ..... 81 en orden por las especialidades): ");
        int dni;
        try {
            dni = FuncionesDeEntradas.leerInt();
        } catch (Exception e) {
            System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            return;
        }

        // Se busca al médico por su DNI.
        Medico medico = medicoServicio.buscarMedico(dni);
        if (medico == null) {
            System.out.println("Médico no encontrado.");
            return;
        }

        // Menú con opciones para el médico.
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("--------------- Menú Médico ---------------");
            System.out.println("-------------------------------------------");
            System.out.println("--   1. Ver Turnos                       --");
            System.out.println("--   2. Generar Reporte Diario           --");
            System.out.println("--   3. Volver al Menú Principal         --");
            System.out.println("-------------------------------------------");
            System.out.print("Opción: ");
            try {
                int opcion = FuncionesDeEntradas.leerInt();

                switch (opcion) {
                    case 1:
                        // Ver los turnos asignados al médico.
                        verTurnosMedico(medico);
                        break;
                    case 2:
                        Reporte reporte = medico.generarReporteDiario();
                        // Acá se va voy a guardar el reporte cuando conectemos con la base de datos...
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            }
        }
    }

    // El médico puede ver la lista de turnos asignados que tiene para el día (esto
    // va a funcionar correctamente cuando conectemnos con la base de datos).
    private static void verTurnosMedico(Medico medico) {
        System.out.println("--------------------------------------------");
        System.out.println("------------- Turnos Asignados -------------");
        System.out.println("--------------------------------------------");
        // Se obtiene la lista de turnos atendidos por el médico y mostrar los detalles
        // de cada uno.
        List<Turno> turnosAtendidos = medico.getTurnosAtendidos();
        for (Turno tur : turnosAtendidos) {
            tur.obtenerDetalles();
        }
    }

    // Menú para el administrador donde puede gestionar médicos y ver los turnos
    // registrados.
    private static void menuAdministrador() {
        // Se solicita el DNI del administrador para acceder al sistema.
        System.out.println("\n------------- Menú Administrador ------------- ");
        System.out.print("-->> Ingrese su DNI (11 o 22): ");
        int dni;
        try {
            dni = FuncionesDeEntradas.leerInt();
        } catch (Exception e) {
            System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            return;
        }

        // Se busca al administrador por su DNI.
        Administrador administrador = administradorServicio.buscarAdministrador(dni);
        if (administrador == null) {
            System.out.println("Administrador no encontrado.");
            return;
        }

        // Menú con opciones para gestionar médicos y ver turnos.
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("--------------- Menú Administrador ---------------");
            System.out.println("--------------------------------------------------");
            System.out.println("--   1. Agregar Médico                          --");
            System.out.println("--   2. Editar Médico                           --");
            System.out.println("--   3. Eliminar Médico                         --");
            System.out.println("--   4. Ver Registro de Turnos                  --");
            System.out.println("--   5. Volver al Menú Principal                --");
            System.out.println("--------------------------------------------------");
            System.out.print("Opción: ");
            try {
                int opcion = FuncionesDeEntradas.leerInt();

                switch (opcion) {
                    case 1:
                        agregarMedico();
                        break;
                    case 2:
                        editarMedico();
                        break;
                    case 3:
                        eliminarMedico();
                        break;
                    case 4:
                        administrador.verRegistroTurnos(listaTurnos.getTurnos());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opción inválida. Vuelva a intentar.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            }
        }
    }

    // El administrador agrega un nuevo médico al sistema.
    private static void agregarMedico() {
        System.out.println("\n------------- Agregar Médico ------------- ");
        try {
            System.out.print("-->> Ingrese DNI: ");
            int dni = FuncionesDeEntradas.leerInt();
            System.out.print("-->> Ingrese nombre: ");
            String nombre = FuncionesDeEntradas.leerString();
            System.out.print("-->> Ingrese apellido: ");
            String apellido = FuncionesDeEntradas.leerString();
            // Se muestra una lista de especialidades para que el administrador seleccione
            // una.
            System.out.println("-->> Seleccione la especialidad:");
            for (Especialidad esp : especialidades) {
                System.out.println(esp.getIdEspecialidad() + ". " + esp.getNombre());
            }
            System.out.print("Opción: ");
            int opcionEspecialidad = FuncionesDeEntradas.leerInt();
            // Se busca la especialidad seleccionada.
            Especialidad especialidadSeleccionada = null;
            for (Especialidad esp : especialidades) {
                if (esp.getIdEspecialidad() == opcionEspecialidad) {
                    especialidadSeleccionada = esp;
                    break;
                }
            }
            if (especialidadSeleccionada == null) {
                System.out.println("Especialidad inválida. Intente de nuevo");
                return;
            }

            // Se crea un nuevo médico y se agrega al sistema.
            Medico nuevoMedico = new Medico(dni, nombre, apellido, especialidadSeleccionada.getNombre());
            administradorServicio.agregarMedico(nuevoMedico);
        } catch (Exception e) {
            System.out.println("Error al agregar médico. Por favor, revise los datos ingresados.");
        }
    }

    // El administrador edita los datos de un médico existente.
    private static void editarMedico() {
        System.out.println("\n-------------- Editar Médico --------------");
        System.out.print("-->> Ingrese DNI del médico a editar(11, 21, 31, 41 .... 81): ");
        int dni;
        try {
            dni = FuncionesDeEntradas.leerInt();
        } catch (Exception e) {
            System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
            return;
        }

        // Se busca el médico en el sistema por su DNI.
        Medico medico = medicoServicio.buscarMedico(dni);
        if (medico == null) {
            System.out.println("Médico no encontrado. Corrobore el DNI ingresado");
            return;
        }

        try {
            // Se solicitan los nuevos datos para actualizar al médico.
            System.out.print("-->> Ingrese nuevo nombre (actual: " + medico.getNombre() + "): ");
            String nuevoNombre = FuncionesDeEntradas.leerString();
            System.out.print("-->> Ingrese nuevo apellido (actual: " + medico.getApellido() + "): ");
            String nuevoApellido = FuncionesDeEntradas.leerString();

            System.out.println("-->> Seleccione nueva Especialidad (actual: " + medico.getEspecialidad() + "):");
            for (Especialidad esp : especialidades) {
                System.out.println(esp.getIdEspecialidad() + ". " + esp.getNombre());
            }
            System.out.print("Opción: ");
            int opcionEspecialidad = FuncionesDeEntradas.leerInt();

            // Se actualiza la información del médico.
            Especialidad especialidadSeleccionada = null;
            for (Especialidad esp : especialidades) {
                if (esp.getIdEspecialidad() == opcionEspecialidad) {
                    especialidadSeleccionada = esp;
                    break;
                }
            }
            if (especialidadSeleccionada == null) {
                System.out.println("Especialidad inválida. Intente de nuevo");
                return;
            }

            // Llama al método de edición del servicio de médicos.
            medicoServicio.editarMedico(dni, nuevoNombre, nuevoApellido, especialidadSeleccionada.getNombre());
        } catch (Exception e) {
            System.out.println("Error al editar médico. Por favor, revise los datos ingresados.");
        }
    }

    // El administrador elimina un médico del sistema.
    private static void eliminarMedico() {
        System.out.println("-----------------------------------------");
        System.out.println("------------ Eliminar Médico ------------");
        System.out.println("-----------------------------------------");
        // Se solicita el DNI del médico a eliminar.
        System.out.print("-->> Ingrese DNI del médico a eliminar (11, 21, 31, 41 ..... 81): ");
        int dni;
        try {
            dni = FuncionesDeEntradas.leerInt();
            medicoServicio.eliminarMedico(dni); // Se elimina el médico del sistema.
        } catch (Exception e) {
            System.out.println("Error en la entrada. Por favor, ingrese un número válido.");
        }
    }
}
