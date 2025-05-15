
//importacion de la clase Scanner
        import java.util.Scanner;

public class ParOImpar{
    public static void main (String[] args){
        
        
        
        // Declaracion de variables y scanner
        int num;
        boolean par;
        Scanner scanner = new Scanner(System.in);

        // Interaccion con el usuario
        System.out.println("\t________Comprobacion de un numero par o impar________ \n\n");
        System.out.println("introduzca el numero a evaluar:");
        
        // Recoleccion de datos
        num = scanner.nextInt();

        // Llamada a funcion de evaluacion
        par = evPar(num);

        // Resultado
        if (par){
            System.out.println("El numero introducido " + num + " es par");
        } else {
            System.out.println("El numero introducido " + num + " es impar");
        }

    }

    //Funcion principal de evaluacion
    public static boolean evPar(int num){
        
        // para que un numero sea par, el resto de la division de su numero entre 2 debe ser 0
        num = num%2;
        
        if (num == 0){
            return true;
        } else {
            return false;
        }
    }
}