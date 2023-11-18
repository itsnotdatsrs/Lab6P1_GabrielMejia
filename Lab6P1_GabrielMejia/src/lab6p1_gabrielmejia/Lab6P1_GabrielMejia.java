package lab6p1_gabrielmejia;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_GabrielMejia {
    
    /*
    
    Perdonen mi Spanglish si ven combinacion de ingles y español en el codigo, el español no es mi primer lenguaje.
    
    */
    
    // Start of Conjuntos
    
    public static String genRandCharArray(int Tamaño) {
        String result = "";
        for (int i = 0; i < Tamaño; i++) {
            result += (char) (65 + (int) (Math.random() * 9));
        }
        return result;
    }//genRandCharArray

    public static void printArray(String Array) {
        System.out.print("[");
        for (int i = 0; i < Array.length(); i++) {
            System.out.print(Array.charAt(i));
            if (i < Array.length() - 1) {
                System.out.print("][");
            }
        }
        System.out.println("]");
    }//PrintArray

    public static String intersection(String set1, String set2) {
        String result = "";
        for (int i = 0; i < set1.length(); i++) {
            char actual = set1.charAt(i);
            if (set2.contains(String.valueOf(actual))) {
                result += actual;
            }
        }
        return result;
    }//Intersection

    public static String difference(String SET1, String SET2) {
        String result = "";
        for (int j = 0; j < SET1.length(); j++) {
            char actual = SET1.charAt(j);
            if (!SET2.contains(String.valueOf(actual))) {
                result += actual;
            }
        }
        return result;
    } //Difference
    // End of Conjuntos
    
    //Start of ¿Cuántos primos tienes?
    public static int[] genRandArray(int Tamaño, int limiteInferior, int limiteSuperior) {
        
        int[] array = new int[Tamaño];
        Random ran = new Random();
        for (int i = 0; i < Tamaño; i++) {
            array[i] = ran.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            }

        return array;
        }

    public static boolean isPrime(int numero) {
    if (numero <= 1) {
        return false;
        }
    
    for (int i = 2; i <= Math.sqrt(numero); i++) {
        
        if (numero % i == 0) { 
            return false;
            }
        }

        return true;
    }

    public static int countPrimeFactors(int numero) {
        int count = 0;
        for (int i = 2; i <= numero; i++) {
            while (numero % i == 0 && isPrime(i)) {
                count++;
                numero /= i;
            }
        }

        return count;
    }

    public static int[] getTotalPrimeCount(int[] array) {
        int[] cuenta = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            cuenta[i] = countPrimeFactors(array[i]);
        }

        return cuenta;
    }
    // End of ¿Cuántos primos tienes?
    
    public static void main(String[] args) {
        
        Scanner ejercicio = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Menu de opciones:");
            System.out.println("1. Conjuntos");
            System.out.println("2. ¿Cuántos primos tienes?");
            System.out.println("3. Salir");

            System.out.print("Selecciona una opcion: ");
            opcion = ejercicio.nextInt();

            switch (opcion) {
                case 1 -> {
                    
                    System.out.println("Conjuntos");
                    Scanner sc = new Scanner(System.in);

                    System.out.print("Size SET1: ");
                    int size1 = sc.nextInt();

                    System.out.print("Size SET2: ");
                    int size2 = sc.nextInt();

                    String set1 = genRandCharArray(size1);
                    String set2 = genRandCharArray(size2);

                    System.out.println("Conjunto 1:");
                    printArray(set1);
                    System.out.println("Conjunto 2:");
                    printArray(set2);

                    System.out.println("Operaciones ");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingrese una opcion:");
                    
                    char operacion = sc.next().charAt(0);

                switch (operacion) {
                    case '1' ->                         {
                            String result = intersection(set1, set2);
                            System.out.println("INTERSECTION(SET1,SET2):");
                            printArray(result);
                        }
                    case '2' ->                         {
                            String result = difference(set1, set2);
                            System.out.println("DIFFERENCE(SET1,SET2):");
                            printArray(result);
                        }
                    default -> System.out.println("Opcion no Valida.");
                }
                    
                    }// End of Conjuntos / Case 1
                
                case 2 -> {
                    System.out.println("¿Cuántos primos tienes?");
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Ingrese el tamaño del arreglo a generar: ");
                    int Tamaño = scanner.nextInt();

                    while (Tamaño <= 1) {
                        System.out.println("El tamaño del arreglo debe ser mayor que 1. Inténtelo nuevamente.");
                        System.out.print("Ingrese el tamaño del arreglo a generar: ");
                        Tamaño = scanner.nextInt();
                    }

                    System.out.print("Ingrese el límite inferior: ");
                    int limiteInferior = scanner.nextInt();

                    System.out.print("Ingrese el límite superior: ");
                    int limiteSuperior = scanner.nextInt();

                    while (limiteSuperior <= limiteInferior) {
                        System.out.println("El límite superior debe ser mayor que el límite inferior. Inténtelo nuevamente.");
                        System.out.print("Ingrese el límite superior: ");
                        limiteSuperior = scanner.nextInt();
                    }

                    int[] randomArray = genRandArray(Tamaño, limiteInferior, limiteSuperior);

                    System.out.print("Arreglo generado: [");
                    for (int i = 0; i < Tamaño; i++) {
                        System.out.print(randomArray[i]);
                        if (i < Tamaño - 1) {
                            System.out.print("][");
                        }
                    }
                    System.out.println("]");

                    int[] primeCounts = getTotalPrimeCount(randomArray);
                    System.out.print("No. divisores primos: [");
                    for (int i = 0; i < Tamaño; i++) {
                        System.out.print(primeCounts[i]);
                        if (i < Tamaño - 1) {
                            System.out.print("][");
                        }
                    }
                    System.out.println("]");
               
                    }// End of ¿Cuántos primos tienes? / Case 2
                
                case 3 -> {
                    
                        }//Fin de Case 3 / Exit Program
                
                default -> System.out.println("Opcion no valida.");
                
            } // End of Switch
            
        } // Verify Opcion is Valid
        
    }// End of Main
    
} // End
