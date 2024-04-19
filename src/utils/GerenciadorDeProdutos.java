package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class GerenciadorDeProdutos {

	private static final String NOME_ARQUIVO = "produtos.txt";
	
	public void verificaECria(String nomeArquivo) {

		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// verificar se o arquivo existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tente criar , caso de erro, exibe o erro
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getLocalizedMessage());
			}
		}

	}
	
	public void adicionarProduto(Produto produto) {
		// writer => escrever
		// BufferedWritwer , FileWriter
		// BufferedWritwer, proporciona uma eficiente escrita
		// FileWriter, escreve dentro de arquivos
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString()); // dados do usuario
			bw.newLine(); // nova linha no arquivo txt
			System.out.println("Produto adicionado com sucessso!");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getLocalizedMessage());
		}
	}
	
	public List<Produto> lerProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		// Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio

			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // divir em tres partes
				// adicionar usuarios a lista
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}
	


	public void deletarProduto(long id) {
		List<Produto> produtos = lerProdutos();
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			// Reescrevendo arquivo com novos usuarios e alteracoes
			reescreverArquivo(produtos);

			System.out.println("Produto deletado com sucesso");

		} else {
			System.out.println("Produto não deletado");
		}	
	}
	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao resscrever o arquivo: " + e.getMessage());
		}

	}
	
	public void listarProduto() {
		List<Produto> produtos = lerProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			System.out.println("Lista de produtos");
			for (Produto produto : produtos) {
				System.out.println("id: " + produto.getId() + ", Nome: " + "" + produto.getNome() + 
						", Preço:" + produto.getPreco() + "" + ", Quantidade:" + produto.getQuantidade());
			}
		}

	}
	
	public void editarProduto(long id, String novoNome, double novoPreco, int novaQuantidade) {
		List<Produto> produtos = lerProdutos();
		boolean encontrado = false;
		for(Produto produto: produtos) {
			if(produto.getId() == id) {
				produto.setNome(novoNome);
				produto.setPreco(novoPreco);
				produto.setQuantidade(novaQuantidade);
				encontrado = true;
				break;
			}
			
		}
		if(encontrado) {
			reescreverArquivo(produtos);
			System.out.println("Produto editado com sucesso!!");
		}else {
			System.out.println("Produto não encontrado");
		}
		
	}
	
			
	
}
