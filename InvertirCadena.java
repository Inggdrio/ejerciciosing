import java.util.Scanner;

/**
 * Ejercicio 3: Invertir una cadena de texto ingresada por el usuario.
 */
public class InvertirCadena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un texto: ");
        String texto = sc.nextLine();

        String invertida = "";

        // Se recorre el texto desde el ultimo caracter hasta el primero
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertida += texto.charAt(i);
        }

        System.out.println("Texto invertido: " + invertida);

        sc.close();
    }
}
