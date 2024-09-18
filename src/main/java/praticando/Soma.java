package praticando;

import java.util.Scanner;

public class Soma {
    // Método para somar dois números
    public static Double somar(double num1, double num2) {
        // Validação para garantir que os números estejam no intervalo de 0 a 100
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
            System.out.println("Os números devem estar entre 0 e 100.");
            return null; // Retorna null se os números não estiverem no intervalo
        }

        // Realiza a soma
        double soma = num1 + num2;

        // Exibe o resultado
        System.out.println("A soma dos números é: " + soma);
        return soma;
    }

    // Método main para executar o programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os números ao usuário
        System.out.println("Digite o primeiro número (entre 0 e 100): ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite o segundo número (entre 0 e 100): ");
        double num2 = scanner.nextDouble();

        // Chama o método somar
        somar(num1, num2);

        scanner.close();
    }
}
