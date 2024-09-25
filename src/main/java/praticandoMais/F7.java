package praticandoMais;

import java.util.Scanner;
public class F7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os valores dos três lados do triângulo
        System.out.println("Digite o valor do primeiro lado do triângulo:");

































































        int lado1 = scanner.nextInt();
        System.out.println("Digite o valor do segundo lado do triângulo:");
        int lado2 = scanner.nextInt();
        System.out.println("Digite o valor do terceiro lado do triângulo:");
        int lado3 = scanner.nextInt();

        // Verifica se os lados formam um triângulo válido
        if (lado1 + lado2 > lado3) {
            if (lado1 + lado3 > lado2) {
                if (lado2 + lado3 > lado1) {
                    // Classifica o triângulo
                    if (lado1 == lado2 && lado2 == lado3) {
                        System.out.println("O triângulo é equilátero.");
                    } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                        System.out.println("O triângulo é isósceles.");
                    } else {
                        System.out.println("O triângulo é escaleno.");
                    }
                } else {
                    System.out.println("Os valores fornecidos não formam um triângulo válido.");
                }
            } else {
                System.out.println("Os valores fornecidos não formam um triângulo válido.");
            }
        } else {
            System.out.println("Os valores fornecidos não formam um triângulo válido.");
        }

        scanner.close();
    }

}
