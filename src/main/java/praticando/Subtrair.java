package praticando;

import java.util.Scanner;

public class Subtrair {
    public static Double subtrair (double num1, double num2){
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100 ){
            System.out.println("Os números devem estar entre 1 e 100.");
            return null;
        }
        double subtrair = num1 - num2;

        System.out.println(" A subtração dos dois números é " + subtrair);
        return subtrair;
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Digite um número de 1 a 100: ");
        double num1 = scanner.nextDouble();

        System.out.println(" Digite um número de 1 a 100: ");
        double num2 = scanner.nextDouble();

        subtrair(num1, num2);

        scanner.close();
    }
}
