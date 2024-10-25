package funcionesUtiles;

//La clase "FuncionesDeEntradas" proporciona métodos para leer cadenas de entrada y números enteros del usuario 

import java.util.Scanner;

public class FuncionesDeEntradas {
    // Se lee la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    // Método para leer una cadena de texto del usuario
    public static String leerString() {
        return scanner.nextLine();
    }

    // Método para leer un número entero, por posibles excepciones
    public static int leerInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input); // Intenta convertir la entrada a un número entero
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero:");
            }
        }
    }
}
