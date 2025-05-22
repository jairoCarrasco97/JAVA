import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/* Este es un pequeño programa orientado a ordenar una serie de números,
 * los cuales se quieran de 2 (ordenar 1 número no tiene lógica) a 20,
 * separados todos por espacios o comas. El output será una lista de
 * menor a mayor, o de mayor a menor, dependiendo de la elección
 * del usuario. Si se quiere, al final del algoritmo, se puede
 * obtener la lista en un .txt.
 */



public class AlgoritmoDeOrdenacion {

    // Variables globales
    static String listaDesordenada;
    static int[] numeros;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        for (int i=0; i<11; i++){
            System.out.print("·" + i + "·");
        } System.out.println(""); //Para saltar el salto de línea
        System.out.println("\n|·    Algoritmo de ordenación    ·|\n");
        for (int i=10; i>=0; i--){
            System.out.print("·" + i + "·");
        } System.out.println(""); //Salto de línea

        pantalla(); //Pantalla y obtención de datos
        algoritmo(); // Algoritmo de resolución
        System.out.println("\n¿Desea guardar la lista ordenada en un archivo? (y/n)");
        String respuesta = scanner.nextLine();
        if (respuesta.equals("y")){
            guardarArchivo(); // Método para guardar la cadena.
        }
        
    }

    // Pantalla y recolección de datos
    public static void pantalla() {
        System.out.println("\nPor favor, introduzca una cadena de números separados (por espacios o comas): ");
        listaDesordenada = scanner.nextLine(); // Recolección de datos
        String[] partes = listaDesordenada.split("[ ,]+"); // División de la cadena
        numeros = new int[partes.length]; // Conversión de la cadena String a un array de numeros enteros

        if (partes.length < 2) {
            System.out.println("Por favor, introduzca al menos 2 números");
            pantalla(); //Llamada a la función para asignar de nuevo una cadena
            return;
        }
        if (partes.length > 20) {
            System.out.println("La cadena es demasiado larga, introduzca un máximo de 20 números");
            pantalla();
            return;
        }

        for (int i=0; i<partes.length; i++){
            numeros[i]=Integer.parseInt(partes[i]); // Asignación de valores a la cadena desordenada
        }
        

    }

    // Algoritmo de ordenación por método burbuja
    public static  void algoritmo() {
        for (int j=0;j<numeros.length -1; j++){
            for (int i=0; i<numeros.length -1; i++){
            if (numeros[i] > numeros[i+1]){
                int temp = numeros[i];           // Generación de cariable local temporal
                numeros[i] = numeros[i+1];
                numeros[i+1] = temp;
            }}
        }
        System.out.println("La lista ordenada es: " +Arrays.toString(numeros)); 
    }

    // Método para guardar la cadena
    public static void guardarArchivo() {
        try {
            System.out.println("Guardando archivo...");
            FileWriter escritor = new FileWriter("ListaOrdenada.txt");
            escritor.write(Arrays.toString(numeros));
            escritor.close();
            System.out.println("Archivo guardadado con éxito 'ListaOrdenada.txt'");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
        }
    
}