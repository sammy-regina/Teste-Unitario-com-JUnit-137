package controle;

// Classe que representa uma despesa
public class Despesa {
    // Atributos da classe
   private String descricao;
   private double valor;
   private String data;

    // Construtor da classe
   public Despesa(String descricao, double valor, String data){
       this.descricao = descricao;
       this.valor = valor;
       this.data = data;
   }
    // Métodos getters para acessar os atributos
   public String getDescricao(){
       return descricao;
   }
   public double getValor(){
       return valor;
   }
   public String getData(){
       return data;
   }

    // Método toString para representar a despesa como uma string
   @Override
    public String toString(){
       return "Despesa{" + "descricao='" + descricao + '\'' + ", valor=" + valor + ", data='" + data + '\'' + '}';
   }
}