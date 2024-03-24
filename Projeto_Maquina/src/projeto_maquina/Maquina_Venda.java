package projeto_maquina;
import java.io.Serializable;
public class Maquina_Venda {
  	// Atributos
	private int cod_produto;
	private String produto;
	private double preco;
	private int quantidade;
	
	// Construtor
	public Maquina_Venda(int cod_produto, String produto, double preco, int quantidade) {
		this.cod_produto = cod_produto;
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	// Metodos Getters and Setters
	
	//Cod_produto
	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	
	//Produto

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	

	//Preco
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	//Quantidade
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\n" + cod_produto +" - "+ produto +" - "+"R$"+ preco +" - "+ quantidade ;
	}

		
	
}


