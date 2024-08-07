// Pacote - conjunto de classes
package br.com.iterasys;

//Bibliotecas

import java.sql.SQLOutput;

//Classe
public class Calculadora {
    //Atributos - caracteristicas

    //Funções e Métodos
    public static double somarDoisNumeros( double num1, double num2 ){
        return num1 + num2;
    }
    public static double subtrairDoisNumeros(double num1, double num2){

        return num1 - num2;
    }
    public static double multiplicarDoisNumeros(double num1, double num2){

        return num1 * num2;
    }
    public static double dividirDoisNumeros(double num1, double num2){

        return num1 / num2;
    }
    public static String dividirPorZero( double num1, double num2){
        try {
            return String.valueOf(num1 / num2);
        }
        catch (ArithmeticException e){
            return "Não é possível dividir por Zero";
        }
    }
}
