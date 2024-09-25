package praticandoMais;

import java.util.Scanner;

public class Triangulo {

    public static Double calcular( double ladoX, double ladoY, double ladoZ ) {
        if (ladoX + ladoY > ladoZ) {
            if (ladoX + ladoZ > ladoY) {
                if (ladoY + ladoZ > ladoX) {
                    if (ladoX == ladoY) {
                        if (ladoY == ladoZ) {
                            System.out.println("O triangulo é Equilátero!");
                        } else {
                            System.out.println("O triangulo é Isóceles!");
                        }
                    } else if (ladoX == ladoZ) {
                        System.out.println("O triangulo é isoceles!");
                    } else if (ladoY == ladoZ) {
                        System.out.println(" O triangulo é Isóceles!");
                    } else {
                        System.out.println("O triangulo é escaleno!");
                    }
                } else {
                    System.out.println(" Os valores fornecidos não são de um triangulo válido!");
                }
            } else {
                System.out.println(" Os valores fornecidos não são de um triangulo válido!");
            }
        } else {
            System.out.println("Os valores fornecidos não formam um triângulo válido.");
        }
        return null;
    }
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do ladoX do triângulo: ");
        double ladoX = scanner.nextDouble();

        System.out.println("Digite o valor do ladoX do triângulo: ");
        double ladoY = scanner.nextDouble();

        System.out.println("Digite o valor do ladoX do triângulo: ");
        double ladoZ = scanner.nextDouble();

        calcular(ladoX, ladoY, ladoZ);

        scanner.close();
    }
}