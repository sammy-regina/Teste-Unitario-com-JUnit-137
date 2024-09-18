package praticando;

import java.util.Scanner;

public class Multiplicar {

    public static Double multiplicar(double num1, double num2){
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100){
            System.out.println(" Os numeros deve estar entre 0 e 100.");
            return null;
        }
        double multiplicar = num1 * num2;

        System.out.println("A multiplicação dos dois numeros é " + multiplicar);
        return multiplicar;
    }
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Digite um número de 1 a 100: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite outro número de 1 a 100: ");
        double num2 = scanner.nextDouble();

        multiplicar(num1, num2);

        scanner.close();
    }
}
