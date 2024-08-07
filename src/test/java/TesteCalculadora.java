//Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import javax.management.ConstructorParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;


//Classe
public class TesteCalculadora {
    //Atributos

    //Funções e Métodos

    @Test
    public void testeSomarDoisNumeros(){
        //Configura
        double num1 = 7;
        double num2 = 5;
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    }
    // Teste de unidade "Data Driven" - direcionado por dados
    @ParameterizedTest
    @CsvSource (value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',') //para avisar que usou a vírgula como separador
    public void testeSomarDoisNumerosLendoLista(String num1, String num2, String resultadoEsperado){
        //Configura
        //Os dados de entrada e o resultado vem da lista

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(num1),Integer.valueOf(num2));
        // Integer.valueoff - para converter string para numero inteiro
        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual );
    }

    @ParameterizedTest // le informação apartir de um arquivo
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')//se não especificar o delimitador, entende-se que é a virgula
    public void testeSomarDoisNumerosLendoArquivo(String num1, String num2, String resultadoEsperado){
        //Configura
        //Os dados de entrada e o resultado vem da lista

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(num1),Integer.valueOf(num2));
        // Integer.valueoff - para converter string para numero inteiro
        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual );
    }

    @Test
    public void testeSubtrairDoisNumeros(){
        double num1 = 9;
        double num2 = 3;
        double resultadoEsperado = 6;

        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        assertEquals(resultadoAtual, resultadoEsperado);
    }
    // Teste de unidade "Data Driven" - direcionado por dados
    @ParameterizedTest
    @CsvSource (value = {
            " 07| 05 | 2.00",
            "56 | 44 | 12.00",
            "10 | 00 | 10.0",
            "15 | 05 | 10.0",
            "08 | 07 | 1.00"
    }, delimiter = '|') //para avisar que usou a vírgula como separador
    public void testeSubtrairDoisNumerosLendoLista(String num1, String num2, String resultadoEsperado){
        //Configura
        //Os dados de entrada e o resultado vem da lista

        //Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(num1),Integer.valueOf(num2));
        // Integer.valueoff - para converter string para numero inteiro
        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual );
    }

    @Test
    public void testeMultiplicarDoisNumeros(){
        double num1 = 2;
        double num2 = 4;
        double resultadoEsperado = 8;

        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        assertEquals(resultadoAtual, resultadoEsperado);
    }
    @ParameterizedTest
    @CsvSource (value = {
            "07 | 05 | 35",
            "56 | 04 | 224",
            "10 | 00 | 00",
            "15 | 05 | 75",
            "08 | 07 | 56"
    }, delimiter = '|') //para avisar que usou a vírgula como separador
    public void testeMultiplicarDoisNumerosLendoLista(String num1, String num2, String resultadoEsperado){
        //Configura
        //Os dados de entrada e o resultado vem da lista

        //Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(Integer.valueOf(num1),Integer.valueOf(num2));
        // Integer.valueoff - para converter string para numero inteiro
        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual );
    }

    public void testeDividirDoisNumeros(){
        double num1 = 6;
        double num2 = 3;
        double resultadoEsperado = 2;

        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        assertEquals(resultadoAtual, resultadoEsperado);
    }
    @ParameterizedTest
    @CsvSource (value = {
            "70 | 05 | 14",
            "36 | 06 | 06",
            "10 | 02 | 05",
            "15 | 05 | 03",
            "80 | 10 | 08"
    }, delimiter = '|') //para avisar que usou a vírgula como separador
    public void testeDividirDoisNumerosLendoLista(String num1, String num2, String resultadoEsperado){
        //Configura
        //Os dados de entrada e o resultado vem da lista

        //Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(Integer.valueOf(num1),Integer.valueOf(num2));
        // Integer.valueoff - para converter string para numero inteiro
        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual );
    }

    @Test
    public void testeDividirPorZero(){
        double num1 = 6;
        double num2 = 0;
        String resultadoEsperado = "Infinity";

        String resultadoAtual = Calculadora.dividirPorZero(num1, num2);

        assertEquals(resultadoEsperado,resultadoAtual);
        System.out.println(num1 + " / " + num2 + " = " + resultadoAtual);
        System.out.println(resultadoEsperado = "Não é possivel dividir por Zero");
    }
}
