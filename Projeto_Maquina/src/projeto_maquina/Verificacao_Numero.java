package projeto_maquina;

import java.util.Scanner;

public class Verificacao_Numero {
	 private static Scanner scan = new Scanner(System.in);

	  public static int LerInt() {
	    while (true) {
	      try {
	        
	        return Integer.parseInt(scan.nextLine());
	      } catch (NumberFormatException e) {
	        System.out.print("Por favor, apenas digite números inteiros!");
	        System.out.println("");
	      }
	    }
      }
	  
	  
	  public static double LerPagamento() {
		    while (true) {
		      try {
		        return Double.parseDouble(scan.nextLine());
		      } catch (NumberFormatException e) {
		        System.out.print("Por favor,digite apenas numeros para o pagamento informando o valor");
		        System.out.println("");
		      }
		    }
	      }
}
