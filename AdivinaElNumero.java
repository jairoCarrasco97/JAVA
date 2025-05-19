import java.util.Random; //Importación de clase Random
import java.util.Scanner; //Importación de clase Scanner

/*
 * Esta aplicación es un minijuego de adivinación de números.
 * El usuario debe adivinar un número aleatorio dentro de un
 * rango definido por el propio usuario. El código proporciona
 * una guía (mayor, menor, o cerca (el usuario está en una posicion de no
 * mas ede un 10% del rango introducido)) con intención de ayudar al usuario.
 */

public class AdivinaElNumero {

        // Declaración de variables
        static int numAleatorio, numUsuario;
        static int min, max;
        static boolean victoria = false;
        static boolean repeticion = true; // Variable para repetir el juego
        static boolean jugado = false;
        static String nuevaPartida;

        
        static Scanner scanner = new Scanner(System.in);  // Objeto clase Scanner
        static Random random = new Random();              // Objeto clase Random


    public static void main (String[] args){


        // Ejecucion de funciones
        while (repeticion == true){
            
            System.out.println("\n\n////////////////////////////////////////////");
            System.out.println("///    BIENVENIDO A ADIVINA EL NÚMERO    ///");
            System.out.println("//////////////////////////////////////////// \n\n");
            System.out.println("¿Desea comenzar una nueva partida? (y/n)");
            nuevaPartida = scanner.nextLine();
            if (nuevaPartida.equals("y")) {
                repeticion = true; // Comienzo/continuado de partida
                victoria = false;  // Reinicio de la variable victoria
                System.out.println("Gracias por su visita, comenzando una nueva partida...");
                pantalla();
                juego();
            }
            else if (nuevaPartida.equals("n")){
                repeticion = false; // Salida de la app
                if (jugado == true) {System.out.println("Gracias por jugar, ¡hasta la próxima!");} // Reconocimiento de partida y despedida
                else {System.out.println("Gracias por su visita, cerrando app...");} // Despedida sin partida
            }
        }
        
    }


    // Pantalla y obtención de datos
    public static void pantalla(){
        System.out.println("\n\n º------------------------º ");
        System.out.println(" |   ADIVINA EL NUMERO    |");
        System.out.println(" º------------------------º ");
        System.out.println("\n\n Rango mínimo y máximo");
        System.out.println(" Introduce el rango mínimo (minimo 0)");
        min = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println(" Introduce el rango máximo (maximo 100)");
        max = scanner.nextInt();
        scanner.nextLine();
        
        /* Condición de veracidad de rango para evitar la inyección de datos
        * excesivamente elevados que puedan interferir en la experiencia del usuario
        * y memoria del sistema */
        if (min >= 0 && max <= 100) {
            System.out.println(" Generando número aleatorio...");
            numAleatorio = generarNumeroAleatorio(min, max);    //Llamada a funcion para generar un numero aleatorio
        } else {
            System.out.println("El rango introducido se excede de rango. Por favor, introduzca un rango entre 0 y 100");
        }
    }

     // Función para generar un número aleatorio
    public static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        numAleatorio = random.nextInt((max - min) + 1) +min; // Generación de número aleatorio dentro del rango
        return numAleatorio;
    }

    // Juego de adivinación
    public static void juego() {
        jugado = true; // Verificación de si se ha jugado al menos una vez
        System.out.println("\n\n ----  Inicio del juego  ----");
        System.out.println(" Adivina el número entre " + min + " y " + max);
        
        // Bucle para adivinación de numero
        while (victoria == false) {
            System.out.println("introduzca un número entre " + min + " y " + max);
            numUsuario = scanner.nextInt(); // Ingreso de número por parte del usuario
            scanner.nextLine();
            
            // Comprobación
            if (numUsuario == numAleatorio) {
                System.out.println("\n\n\n*** ¡FELICIDADES!, acertaste el número *** \n\n\n");
                victoria = true; // Salida del bucle
            }
            else if (Math.abs(numUsuario - numAleatorio) <= (max - min) / 10) {
                System.out.println("¡Estuviste cerca! prueba de nuevo");
            }
            else if (numUsuario < numAleatorio){
                System.out.println("El número es mayor al que has introducido");
            }
            else if (numUsuario > numAleatorio){
                System.out.println("El número es menor al que has introducido");
            }
            else if (numUsuario < min || numUsuario > max){
                System.out.println("El número introducido se excede del rango");
            }
            
            }
        }
    
}


