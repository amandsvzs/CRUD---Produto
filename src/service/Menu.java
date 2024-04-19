package service;

import java.util.List;
import java.util.Scanner;
import models.Produto;
import utils.GerenciadorDeProdutos;

public class Menu {

Scanner sc = new Scanner(System.in);
	
	//Gerenciador
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();
	//construtor vazio
	public Menu() {
	//toda vez que a classe menu, for instanciado, o nosso arquivo sera verificado
		gp.verificaECria("produtos.txt");
	}
	
	public void criar() {
		
		System.out.println("Digite o nome do produto: ");
	    String nome = sc.next();
	    
	    System.out.println("Digite o preço do produto: ");
	    double preco = sc.nextDouble();
	    
	    System.out.println("Digite a quantidade de produtos: ");
	    int quantidade = sc.nextInt();
	    
	    long id = getNextId();
	    
	    Produto p = new Produto(id, nome, preco, quantidade);
	    gp.adicionarProduto(p);
		
	}
	
	public void editar() {
		System.out.println("Digite o id do produto: ");
		long id = sc.nextLong();
		System.out.println("Digite o novo nome do produto: ");
		String nome = sc.next()	;
		System.out.println("Digite o novo preço do produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a nova quantidade de produtos: ");
		int quant = sc.nextInt();
		gp.editarProduto(id, nome, preco, quant);
		
		
		
		
		
	
}
	public void deletar() {
	System.out.println("Digite o id do produto que deseja deletar: ");
	long id= sc.nextInt();
	gp.deletarProduto(id);
	
	
	
}
	
	  public void listar() {
	    	gp.listarProduto();
	    	
			
		}
	  public void visualizar() {
	    	System.out.println("Digite o id do produto que deseja visualizar: ");
	    	int id = sc.nextInt();
	    }
	  
	  
	  public long getNextId() {
	    	List<Produto> produtos = gp.lerProdutos();
	    	  long maxId = 0;
	    	  //for => forEach
	    	  //unico usuario : lista com todos
	    	  for(Produto produto : produtos) {
	    		  long id = produto.getId();
	    		  //1
	    		  if(id > maxId) {
	    			  // logica para decobrir o ultimo id
	    			  maxId = id;
	    			  
	    		  }
	    		  
	    	  }
	    	  //soma 1 + o ultimo
	    	  return maxId + 1;
	    }

}
