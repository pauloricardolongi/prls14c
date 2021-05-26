package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.ProdutoImportado;
import entidades.Produto;
import entidades.ProdutoUsado;

public class App {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("Entre com o número de Produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" + i + " dados:");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (type == 'c') {
				Produto prod= new Produto(nome,preco);
				lista.add(prod);
			}
			else if (type == 'u') {
				System.out.print("Data de Fabricação (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				
				Produto prod= new ProdutoUsado(nome, preco, date);
				lista.add(prod);
				
			}
			else {
				System.out.print("taxaAlfandega: ");
				double taxaAlfandega = sc.nextDouble();
				Produto prod= new ProdutoImportado(nome,preco,taxaAlfandega);
				lista.add(prod);
			}
		}

		System.out.println();
		System.out.println("ETIQUETA DE PREÇOS:");
		for (Produto prod : lista) {
			System.out.println(prod.etiquetaPreco());
		}
		
		sc.close();
	}
}


	


