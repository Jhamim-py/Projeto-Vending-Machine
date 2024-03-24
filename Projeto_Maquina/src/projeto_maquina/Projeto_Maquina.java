package projeto_maquina;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Projeto_Maquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int atualizacao = 0;
	double quantia = 0;
        int pagamento = 0;
        int quant = 0;
        double valor = 0;
	Scanner sc = new Scanner(System.in);
		
		// Caminho para o arquivo SVC
		String path = "Digite o local do arquivo";

		//Criação do ArrayList
	  List<Maquina_Venda> list = new ArrayList <Maquina_Venda>();
	  
	  //Leitura do arquivo SVC
	  try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			
		// Colocando o arquivo lido dentro do ArrayList criado por meio de um Loop(While)
			while (line != null) {
				
				// separar os elementos por ";" e armazena-los em um vetor 
				String [] vetor = line.split(";");
				
			
				int cod_produto = Integer.parseInt( vetor[0]);
				String produto = vetor[1];
				double preco = Double.parseDouble(vetor[2]);
				int quantidade = Integer.parseInt(vetor[3]);
				
				Maquina_Venda maquina = new Maquina_Venda(cod_produto, produto, preco, quantidade);
				
				//Adicionando o objeto criado dentro do ArrayList "list"
				list.add(maquina);
				
				line = br.readLine();
			}
			
	
			
			System.out.println("|| Bem vindo a Vending Machine!!||");
			System.out.println("\n Menu de Produtos:");
			System.out.println("Código do produto  ------ Produto ------ Preço ----- Quantidade");
			
			for(Maquina_Venda produtos : list) {
				System.out.println(produtos);
		       }
			
    System.out.println("\nSelecione as opções abaixo para realizar as compras");
    while(true) {
		 
	 
    System.out.println("\nDigite [1] para realizar uma compra ou digite [2] para sair da máquina: ");
    int codigo = Verificacao_Numero.LerInt();    
    
    //sair do loop (While)
    if(codigo == 2) {
    break;	
    }

        switch(codigo) {
    
    case 1:
    	
    	  System.out.println("\n||Digite o código do produto que deseja:|| ");
          int prod = Verificacao_Numero.LerInt();
          int indice = prod - 1;
    	
    	if (prod > 10 || prod < 0) {
            System.out.println("Código de produto inválido");
            break;
           }
    	
		  System.out.println(list.get(indice));
		  System.out.println("\nInforme e quatidade desejada: ");
		  quant = Verificacao_Numero.LerInt();
		  
		  if(list.get(indice).getQuantidade() == 0){
			  System.out.println("O produto escolhido não está disponível no estoque");
			  break;
		    }
		  else if(quant > list.get(indice).getQuantidade()) {
			  System.out.println("Apenas temos em estoque "+list.get(indice).getQuantidade()+" do produto desejado.");
		  break;
		  }
		  else if(quant == 0) {
			  System.out.println("Nenhum produto selecionado");
		  break;
		  }
		  else {
			  valor = list.get(indice).getPreco() * quant;
		  }
		  
		  System.out.println("\nInforme a forma de pagamento: [1] Dinheiro [2] Cartão [3] Pix");
		  pagamento = Verificacao_Numero.LerInt();
		  
		  switch (pagamento) {
		  case 1:
			  
			 System.out.println("|| AVISO!|| O troco máximo é de 50 Reais!" );
			 
			 System.out.println("\nInforme o valor do pagamento a ser entregue:");
			 quantia = Verificacao_Numero.LerPagamento();
			 
			 if ( (quantia - valor ) > 50 ) {
				 System.out.println("Quantia entregue excede o valor máximo para troco.Compra não realizada com sucesso.");
				 break;
		      } 
			
			 else if (quantia < valor) {
		    	System.out.println("Quantia insuficiente.Compra não realizada com sucesso.");
		    	break;
		      }  
		     
		     else {
		    	System.out.println("Compra realizada com sucesso!!");
		    	
		    	System.out.println("O total de troco foi de: " + (quantia - valor));
		    	
		    	//Atualizando a quantidade do produto
		    	atualizacao = list.get(indice).getQuantidade()-quant;
		    	list.get(indice).setQuantidade(atualizacao);
		    	break;
		    	
		      }
          case 2:
			  System.out.println("Compra realizada com sucesso!!");
			   atualizacao = list.get(indice).getQuantidade()-quant;
		      list.get(indice).setQuantidade(atualizacao);
		      break;
			  
		  case 3:
			  System.out.println("Compra realizada com sucesso!!");
			   atualizacao = list.get(indice).getQuantidade()-quant;
		      list.get(indice).setQuantidade(atualizacao);
		      break;
		   
		  default:
			  System.out.println("A opção escolhida não está disponível");
			  break;
		  }
        
        break;
    default:
    	System.out.println("Código inválido");
         }
	  }
   

br.close();

FileWriter fw2 = new FileWriter(path,true);
fw2.close();

FileWriter fw = new FileWriter(path);

BufferedWriter bw = new BufferedWriter(fw);

bw.write("Código;Produto;PreçoR$;Quantidade");
bw.newLine();
for (int i = 0 ; i < list.size(); i ++){
	bw.write(list.get(i).getCod_produto() +";"+list.get(i).getProduto()+";"+list.get(i).getPreco()+";"+list.get(i).getQuantidade() );
	bw.newLine();
   }
   bw.close();
   fw.close();

}
	  
	  
	  catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	  
      
    }
}