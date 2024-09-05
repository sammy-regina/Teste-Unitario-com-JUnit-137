package br.com.iterasys;

// Importações necessárias
import java.util.ArrayList;//ArrayList é uma das principais maneiras que manipulamos listas, dicionários, filas, pilhas ou qualquer outro tipo de coleção
import java.util.Scanner;//para simplificar a leitura de diversas formas de entrada do usuário

// Classe principal que contém a lógica do programa
public class ControleGastos {
    // Atributos da classe
    private double rendaMensal;
    private ArrayList<Despesa> despesas;
    private Scanner scanner;

    // Construtor da classe
    public ControleGastos(){
        despesas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    //Método para adicionar a renda mensal
    public void adicionarRenda(){
        System.out.println("Informe sua renda mensal: ");
        rendaMensal = scanner.nextDouble();
        scanner.nextLine(); //consumir a nova linha
        System.out.println("Renda mensal adicionada com sucesso!");
    }
    //Método para adicionar uma nova despesas
    public void adicionarDespesa(){
        System.out.println("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.println("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); //Consumir a nova linha
        System.out.println("Data (dd/mm/yyyy): ");
        String data = scanner.nextLine();
        Despesa despesa = new Despesa(descricao, valor, data);
        despesas.add(despesa);
        System.out.println("Despesa adicionada com sucesso!");
    }
    //Metodo para listar todas as despesas
    public void listarDespesas(){
        if (despesas.isEmpty()){
            System.out.println("Nenhuma despesa registrada.");
        }else {
            for (Despesa despesa : despesas){
                System.out.println(despesa);
            }
        }
    }
    //Método para calcular o total das despesas
    public void calcularTotalDespesas(){
        double total = 0;
        for (Despesa despesa : despesas){
            total += despesa.getValor();
        }
        System.out.println(" Total das despesas: R$ " + total);
    }
    //Método calcular o saldo mensal
    public void calcularSaldoMensal(){
        double totalDespesas = 0;
        for (Despesa despesa : despesas){
            totalDespesas += despesa.getValor();
        }
        double saldo = rendaMensal - totalDespesas;
        System.out.println("Saldo mensal: R$ " + saldo);
    }
    //Método para exibir o menu e interagir com o usuário
    public void exibirMenu(){
        int opcao;
        do {
            System.out.println("\n--- Controle de Gastos Mensais ---");
            System.out.println("1. Adicionar Renda Mensal");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Listar Despesas");
            System.out.println("4. Calcular Total das Despesas");
            System.out.println("5. Calcular Saldo Mensal");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());//consultar a nova linha
            switch (opcao){
                case 1:
                    adicionarRenda();
                    break;
                case 2:
                    adicionarDespesa();
                    break;
                case 3:
                    listarDespesas();
                    break;
                case 4:
                    calcularTotalDespesas();
                    break;
                case 5:
                    calcularSaldoMensal();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao !=6);
    }
    //Método principal para iniciar o programa
    public static void main(String[]args){
        ControleGastos controle = new ControleGastos();
        controle.exibirMenu();
    }
}
