import java.util.Scanner;

/* El código mostrado a continuación tiene la función principal de
 * mostrar un rombo con un lado N de máximo 25, para evitar posibles errores
 * en la introducción de datos excesivamente elevados.
 */



public class RomboLadoN {
    public static void main(String[] args) {

    // Declaración de variables
    int n; // Aquí se almacenará la longitud del lado del rombo

    // Pantalla de bienvenida
    pantalla();

    // Obtención de datos
    n = obtencionLado();

    // Dibujado en pantalla del rombo

    rombo(n);

    // Fin del programa principal


    }

    public static int obtencionLado() {

        // Declaración de objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        int longLado; // Aquí se almacenará la longitud del lado del rombo de forma local y temporal        

        System.out.println("\n\n Por favor, introduzca la longitud del lado del rombo (maximo 25)");
        longLado = scanner.nextInt(); // Obtención y almacenamiento del dato necesario
        if (longLado >= 1 && longLado <= 25) {
            System.out.println("Valor almacenado correctamente: " + longLado);
            return longLado; // Retorno del valor obtenido
        }
        else {
            System.out.println("Error al introducir el valor, por favor introduzca un valor entre 1 y 25.");
            return obtencionLado();
        }
    }

    public static void rombo(int n) {
        
        // Dibujado superior del rombo
        for (int i=1; i <=n; i++) {
            for (int j=1; j<=n-i; j++) {
                System.out.print(" "); //Dibujado de espacios blancos
            }
            for (int j=1; j<=(2*i)-1; j++) {
                System.out.print("*"); // Dibujado por líneas del rombo
            }
            System.out.println(""); // Salto de línea
        }
        // Dibujado inferior del rombo
        for (int i=n-1; i>=1; i--) {
                for (int j=1; j<=n-i; j++) {
                System.out.print(" "); //Dibujado de espacios blancos
            }
            for (int j=1; j<=(2*i)-1; j++) {
                System.out.print("*"); // Dibujado por líneas del rombo
            }
            System.out.println(""); // Salto de línea  
        }

    }

    public static void pantalla() {
        System.err.println("                *");
        System.out.println("               ***");
        System.out.println("  *          *******          *");
        System.out.println(" ***       ***********       ***");
        System.out.println("*****    Rombo de lado N    *****");
        System.out.println(" ***       ***********       ***");
        System.out.println("  *          *******          *");
        System.err.println("               ***");
        System.out.println("                *");
    }
}
