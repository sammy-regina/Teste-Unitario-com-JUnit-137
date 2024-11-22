package praticandoMais;

import java.util.Scanner;

public class Cadastro {

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        String cadastrado = nome + " " + sobrenome;

        String cadastrado1 = cadastrado.toUpperCase();

        System.out.println("Nome: " + cadastrado1);

        scanner.close();
    }
}
