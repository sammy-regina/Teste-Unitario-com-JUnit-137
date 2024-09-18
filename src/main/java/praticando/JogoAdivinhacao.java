/*Explicação do Código:
Importação das Classes: import java.util.Random; e import java.util.Scanner; - Importa as classes Random e Scanner para gerar números aleatórios e ler a entrada do usuário, respectivamente.
Criação do Objeto Random: Random random = new Random(); - Cria um objeto Random para gerar números aleatórios.
Geração do Número Aleatório: int numberToGuess = random.nextInt(100) + 1; - Gera um número aleatório entre 1 e 100.
Inicialização do Contador de Tentativas: int numberOfTries = 0; - Inicializa o contador de tentativas.
Criação do Objeto Scanner: Scanner scanner = new Scanner(System.in); - Cria um objeto Scanner para ler a entrada do usuário.
Variável de Palpite: int guess; - Declara uma variável para armazenar o palpite do usuário.
Variável de Controle de Vitória: boolean win = false; - Declara uma variável para controlar se o usuário acertou o número.
Loop de Adivinhação: while (!win) { ... } - Loop que continua até o usuário adivinhar o número.
Leitura do Palpite: guess = scanner.nextInt(); - Lê o palpite do usuário.
Verificação do Palpite: if (guess == numberToGuess) { ... } - Verifica se o palpite está correto e ajusta a variável win e exibe mensagens apropriadas.
Mensagem de Vitória: System.out.println("You win! The number was " + numberToGuess); - Exibe a mensagem de vitória e o número de tentativas.*/

package praticando;

import java.util.Random;
import java.util.Scanner;//A classe Scanner é usada para ler a entrada do usuário a partir de várias fontes

public class JogoAdivinhacao {
    public static void main(String[] args){
        // Cria um objeto Random para gerar números aleatórios
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;// Gera um número aleatório entre 1 e 100
        int numberOfTries = 0; // Inicializa o contador de tentativas
        Scanner scanner = new Scanner(System.in);// Cria um objeto Scanner para ler a entrada do usuário
        int guess; // Variável para armazenar o palpite do usuário
        boolean win = false;  // Variável para verificar se o usuário acertou

        while (!win){
            System.out.println("Advinhe um numero entre 1 e 100: ");
            guess = scanner.nextInt();// Lê o palpite do usuário
            numberOfTries++;// Incrementa o contador de tentativas

            if (guess == numberToGuess){
                win = true; // O usuário acertou o número
            }else if (guess < numberToGuess){
                System.out.println("Seu palpite é muito baixo.");
            }else {
                System.out.println("Seu palpite é muito alto");
            }
        }
        System.out.println("Você ganhou! O número era " + numberToGuess);
        System.out.println("Você levou " + numberOfTries + " tentativas.");
    }
}
