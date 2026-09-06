import java.util.Scanner;

/**
 * Ejercicio 2: Contador de vocales y consonantes.
 * La palabra ingresada esta en minusculas y no contiene simbolos,
 * caracteres especiales, acentos ni numeros.
 */
public class ContadorVocalesConsonantes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una palabra (en minusculas, sin acentos): ");
        String palabra = sc.nextLine();

        int vocales = 0;
        int consonantes = 0;

        // Se recorre la palabra letra por letra
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i'
                    || letra == 'o' || letra == 'u') {
                vocales++;
            } else if (letra >= 'a' && letra <= 'z') {
                // Cualquier otra letra del abecedario es consonante
                consonantes++;
            }
        }

        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);

        sc.close();
    }
}
