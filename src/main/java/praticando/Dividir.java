package praticando;

import java.util.Scanner;

public class Dividir {
    public static Double dividir(double num1, double num2){
        if(num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100){
            System.out.println(" Os numeros devem estar entre 0 e 100.");
            return null;
        }
        double dividir = num1 / num2;

        System.out.println("A divisão entre os numeros é: " + dividir);
         return dividir;
    }
    public  static  void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número entre 0 e 100: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite um número entre 0 e 100: ");
        double num2 = scanner.nextDouble();

        dividir(num1, num2);

        scanner.close();
    }

}
