// Esta clase `Main` es la interfaz principal del sistema de gestión de turnos para la Clínica CBA.
// Aquí se presentan los menús principales de interacción, permitiendo que el usuario seleccione si es un Paciente, Médico o Administrador.
// Dependiendo de la elección, el sistema mostrará diferentes opciones y funcionalidades específicas para cada tipo de usuario.
// La clase también maneja validaciones y solicitudes de datos del usuario a través de la consola.


package view;

import controller.AdministradorServicio;
import controller.MedicoServicio;
import controller.PacienteServicio;
import model.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Son las nstancias de servicios para manejar pacientes, médicos y administradores en el sistema.
    private static PacienteServicio pacienteServicio = new PacienteServicio();
    private static MedicoServicio medicoServicio = new MedicoServicio();
    private static AdministradorServicio administradorServicio = new AdministradorServicio();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) { // Bucle principal del sistema para mostrar el menú de selección de rol.
            System.out.println("===============================================");
            System.out.println("=== SISTEMA DE GESTIÓN DE TURNOS CLÍNICA CBA ==");
            System.out.println("===============================================");
            System.out.println("Seleccione su rol:                            =");
            System.out.println("1. Paciente                                   =");
            System.out.println("2. Médico                                     =");
            System.out.println("3. Administrador                              =");
            System.out.println("4. Salir                                      =");
            System.out.println("===============================================");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    menuPaciente();
                    break;
                case "2":
                    menuMedico();
                    break;
                case "3":
                    menuAdministrador();
                    break;
                case "4":
                    System.out.println("Saliendo del sistema... Gracias por ser parte!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente");
            }
        }
    }

     // Menú para los pacientes que permite ingresar sus datos y solicitar un turno.
    private static void menuPaciente() {
        System.out.println("-----------------------------------");
        System.out.println("---------- Menú Paciente ----------");
        System.out.println("-----------------------------------");

        try {
            // Solicita y valida el DNI del paciente.
            int dni;
            while (true) {
                System.out.print("-- > Ingrese su DNI para solicitar |TURNO|: ");
                String dniInput = scanner.nextLine();
                try {
                    dni = Integer.parseInt(dniInput); // Intenta convertir el DNI a un entero.
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\n(Incorrecto, el DNI debe ser numérico)");
                }
            }

            // Validación del nombre (solo letras y espacios)
            String nombre;
            while (true) {
                System.out.print("-- > Ingrese su nombre: ");
                nombre = scanner.nextLine();
                if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
                    break;
                System.out.println("\n(Incorrecto, el nombre no puede tener datos numericos)");

            }

            // Validación del apellido (solo letras y espacios)
            String apellido;
            while (true) {
                System.out.print("-- > Ingrese su apellido: ");
                apellido = scanner.nextLine();
                if (apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
                    break;
                System.out.println("\n(Incorrecto, el aoellido no puede tener datos numericos)");

            }

            // Se solicita el teléfono del paciente
            System.out.print("-- > Ingrese su teléfono: ");
            String telefono = scanner.nextLine();

            // Se solicita y valida el email del paciente
            String email;
            while (true) {
                System.out.print("-- > Ingrese su email: ");
                email = scanner.nextLine();
                if (email.contains("@"))
                    break;
                System.out.println("\n(Incorrecto, el email debe contener '@')");
            }

            // Se solicita la especialidad médica deseada por el paciente.
            System.out.println("---------------------------------------------------------");
            System.out.println("\n-- > Seleccione el ID de la especialidad que desea:");
            System.out.println("---------------------------------------------------------");
            System.out.println("1 - Medicina General");
            System.out.println("2 - Pediatría");
            System.out.println("3 - Ginecología");
            System.out.println("4 - Cardiología");
            System.out.println("5 - Dermatología");
            System.out.println("6 - Oncología");
            System.out.println("7 - Gastroenterología");
            System.out.println("8 - Urología");

            int especialidadId;
            while (true) {
                System.out.print("\n-- > Ingrese el ID de la especialidad: ");
                String especialidadInput = scanner.nextLine();
                try {
                    especialidadId = Integer.parseInt(especialidadInput);
                    if (especialidadId >= 1 && especialidadId <= 8) // Asegura que el ID esté en el rango válido.
                        break;
                    System.out.println("Incorrecto, el ID de especialidad es invalido.");
                } catch (NumberFormatException e) {
                    System.out.println("Incorrecto, porfavor ingrese un número válido.");
                }
            }

             // Genera un código único de turno para el paciente.
            String codigoUnico = pacienteServicio.generarCodigoTurno();

            // Crea el objeto `Paciente` y lo registra.
            Paciente paciente = new Paciente(dni, nombre, apellido, telefono, email, especialidadId, codigoUnico);
            pacienteServicio.agregarPaciente(paciente);
            System.out.println("---------------------------------------------------------");

            System.out.println("-- Su código único de turno es -->  " + codigoUnico + " <--");
            System.out.println("---------------------------------------------------------");

        } catch (InputMismatchException e) {
            System.out.println("Invalido!! Trate de ingresar los datos en el formato correcto.");
            scanner.nextLine(); // Limpia el buffer para evitar bucles infinitos
        }
    }

    // Menú para médicos, que permite generar reportes y ver la lista de pacientes.
    private static void menuMedico() {
        System.out.println("-----------------------------------");
        System.out.println("---------- Menú Médico ------------");
        System.out.println("-----------------------------------");
        System.out.println("12345678 - Dr. Carlos ");
        System.out.println("-----------------------------------");
        System.out.println("23456789 - Dra. María");
        System.out.println("-----------------------------------");
        System.out.println("34567890 - Dr. Jorge");
        System.out.println("-----------------------------------");
        System.out.println("45678901 - Dra. Laura");
        System.out.println("-----------------------------------");
        System.out.println("56789012 - Dr. Pablo");
        System.out.println("-----------------------------------");
        System.out.println("67890123 - Dra. Ana");
        System.out.println("-----------------------------------");
        System.out.println("78901234 - Dr. Manuel");
        System.out.println("-----------------------------------");
        System.out.println("89012345 - Dra. Lucía");
        System.out.println("-----------------------------------");
        System.out.print("-- > Ingrese su DNI correspondiente: ");

        int dniMedico = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Medico medico = medicoServicio.buscarMedico(dniMedico);

        // Verifica si el médico existe en la base de datos
        if (medico == null) {
            System.out.println("Medico no encontrado en la base de datos!.");
            return; // Salir del método si el médico no existe.
        }

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("--------- Opciones Médico ---------");
            System.out.println("-----------------------------------");
            System.out.println("1. Generar Reporte Diario         -");
            System.out.println("2. Ver Lista de Pacientes         -"); 
            System.out.println("3. Volver al menú principal       -");
            System.out.println("-----------------------------------");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    Reporte reporte = medicoServicio.generarReporteDiario(dniMedico);
                    break;
                case "2":
                    // Muestra lista de pacientes con formato de tabla
                    List<Paciente> pacientes = medicoServicio.obtenerPacientes();
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-10s %-15s %-15s %-15s %-30s %-15s%n",
                                "DNI", "Nombre", "Apellido", "Teléfono", "Email", "Especialidad");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------");
                        for (Paciente paciente : pacientes) {
                            System.out.printf("%-10d %-15s %-15s %-15s %-30s %-15d%n",
                                    paciente.getDni(), paciente.getNombre(), paciente.getApellido(),
                                    paciente.getTelefono(), paciente.getEmail(), paciente.getEspecialidadId());
                        }
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------");

                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

     // Menú para administradores, con opciones de gestión de médicos y ver lista de médicos.
    private static void menuAdministrador() {
        System.out.println("-----------------------------------");
        System.out.println("-------- Menú Administrador -------");
        System.out.println("-----------------------------------");

        // Validación del DNI del Administrador
        int dniAdmin;
        while (true) {
            System.out.println("34567890 - Adm Laura");
            System.out.println("-----------------------------------");
            System.out.println("45678901 - Adm Ricardo");
            System.out.println("-----------------------------------");
            System.out.print("-- > Ingrese su DNI correspondiente: ");
            String dniInput = scanner.nextLine();
            try {
                dniAdmin = Integer.parseInt(dniInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalido, el DNI debe ser numérico.");
            }
        }

        // Verifica si el administrador existe
        Administrador admin = administradorServicio.buscarAdministrador(dniAdmin);
        if (admin == null) {
            System.out.println("Administrador no encontrado en la base de datos!.");
            return;
        }

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("--------- Opciones Administrador ---------");
            System.out.println("------------------------------------------");
            System.out.println("1. Agregar Médico                       --");
            System.out.println("2. Editar Médico                        --");
            System.out.println("3. Eliminar Médico                      --");
            System.out.println("4. Ver Lista de Médicos                 --");
            System.out.println("5. Volver al menú principal             --");
            System.out.println("------------------------------------------");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    // Agregar médico (validación y creación de nuevo médico)
                    int dniMedico;
                    while (true) {
                        System.out.print("--> DNI del Médico: ");
                        String dniMedicoInput = scanner.nextLine();
                        try {
                            dniMedico = Integer.parseInt(dniMedicoInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrecto! El DNI debe ser numérico.");
                        }
                    }

                    // Validación del nombre (solo letras y espacios)
                    String nombre;
                    while (true) {
                        System.out.print("--> Nombre del Médico: ");
                        nombre = scanner.nextLine();
                        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
                            break;
                        System.out.println("Error: El nombre no debe tener números.");
                    }

                    // Validación del apellido (solo letras y espacios)
                    String apellido;
                    while (true) {
                        System.out.print("--> Apellido del Médico: ");
                        apellido = scanner.nextLine();
                        if (apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
                            break;
                        System.out.println("Error: El apellido no debe tener números.");

                    }

                    // Validación del ID de Especialidad
                    int especialidadId;
                    while (true) {
                        System.out.println("-----------------------------------");
                        System.out.println("----     ID de Especialidad    ----");
                        System.out.println("-----------------------------------");
                        System.out.println("\n1, 'Medicina General ");
                        System.out.println("-----------------------------------");
                        System.out.println("2, 'Pediatría");
                        System.out.println("-----------------------------------");
                        System.out.println("3, 'Ginecología");
                        System.out.println("-----------------------------------");
                        System.out.println("4, 'Cardiología");
                        System.out.println("-----------------------------------");
                        System.out.println("5, 'Dermatología");
                        System.out.println("-----------------------------------");
                        System.out.println("6, 'Oncología");
                        System.out.println("-----------------------------------");
                        System.out.println("7, 'Gastroenterología");
                        System.out.println("-----------------------------------");
                        System.out.println("8, 'Urología");
                        System.out.println("-----------------------------------");
                        System.out.print("ID de Especialidad: ");
                        String especialidadInput = scanner.nextLine();
                        try {
                            especialidadId = Integer.parseInt(especialidadInput);
                            if (especialidadId >= 1 && especialidadId <= 8)
                                break; // Rango válido
                            System.out.println("Error: ID de especialidad no válido.");
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrecto: Ingrese un número válido para el ID.");
                        }
                    }

                    // Ingreso de la matrícula del Médico
                    System.out.print("Matrícula del Médico (Por ej:|M123456|): ");
                    String matricula = scanner.nextLine();
                    Medico nuevoMedico = new Medico(dniMedico, nombre, apellido, especialidadId, matricula);
                    administradorServicio.agregarMedico(nuevoMedico);
                    break;

                case "2":
                    // Validación del DNI del Médico a editar
                    int dniMedicoEditar;
                    while (true) {
                        System.out.print("--> DNI del Médico a Editar: ");
                        String dniEditarInput = scanner.nextLine();
                        try {
                            dniMedicoEditar = Integer.parseInt(dniEditarInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El DNI debe ser numérico.");
                        }
                    }

                    Medico medico = medicoServicio.buscarMedico(dniMedicoEditar);
                    if (medico != null) {
                        System.out.print("--> Nuevo Nombre: ");
                        medico.setNombre(scanner.nextLine());
                        System.out.print("--> Nuevo Apellido: ");
                        medico.setApellido(scanner.nextLine());
                        administradorServicio.editarMedico(medico);
                    } else {
                        System.out.println("Médico no encontrado.");
                    }
                    break;

                case "3":
                    // Validación del DNI del Médico a eliminar
                    int dniMedicoEliminar;
                    while (true) {
                        System.out.print("--> DNI del Médico a Eliminar: ");
                        String dniEliminarInput = scanner.nextLine();
                        try {
                            dniMedicoEliminar = Integer.parseInt(dniEliminarInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("El DNI debe ser numérico, intente nuevamente.");
                        }
                    }

                    administradorServicio.eliminarMedico(dniMedicoEliminar);
                    break;

                case "4":
                    List<Medico> medicos = administradorServicio.obtenerMedicos();
                    if (medicos.isEmpty()) {
                        System.out.println("No hay médicos registrados.");
                    } else { // Muestra lista de medicos con formato de tabla
                        System.out.println(
                                "----------------------------------------------------------------------------");
                        System.out.printf("%-10s %-15s %-15s %-15s %-20s%n",
                                "DNI", "Nombre", "Apellido", "Especialidad", "Matrícula");
                        System.out.println(
                                "----------------------------------------------------------------------------");
                        for (Medico med : medicos) {
                            System.out.printf("%-10d %-15s %-15s %-15d %-20s%n",
                                    med.getDni(), med.getNombre(), med.getApellido(),
                                    med.getEspecialidadId(), med.getMatricula());
                        }
                        System.out.println(
                                "----------------------------------------------------------------------------");
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
