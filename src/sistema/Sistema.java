package sistema;

import java.util.Scanner;

import service.Menu;

public class Sistema {
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Menu hm = new Menu();
			int opcao = 0;
			do {
				System.out.println("1 - Criar\n2 - Editar \n3 - Deletar \n4 - Listar\n5 - Visualizar\n9 - Sair\n");
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1: {
					hm.criar();
					break;
				}
				case 2: {
					hm.editar();
					break;
					
				}
				case 3: {
					hm.deletar();
					break;
					
				}
				case 4: {
					hm.listar();
					break;
					
				}
				case 5:{
					hm.visualizar();
					continue;
				}
				case 9:
					System.out.println("Sistema encerrado");
					break;
				default:
					
					
				}
				
			} while (opcao != 9);
			sc.close();
		

	}
	
	
}
