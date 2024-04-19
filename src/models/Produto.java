package models;

public class Produto {

	private long id;
	private String nome;
	private double preco;
	private int quantidade;
	
	
	public Produto (long id2, String nome, double preco, int quantidade) {
		this.id = id2;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

	@Override 
	public String toString() {
		return id + ";" + nome +";" + preco + ";" + quantidade;
	}
}
