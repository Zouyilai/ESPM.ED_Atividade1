import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			if( opcao < 1 || opcao > 6) {
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			} else {
				switch(opcao) {
					case 1:
						Util.abrirConta();
						break;
					case 2:
						Util.realizarSaque();
						break;
					case 3:
						Util.realizarDeposito();
						break;
					case 4:
						Util.relatorioContas();
						break;
					case 5:
						Util.encerrarConta();
						break;
				
				}
				
			}
		} while(opcao != 6);
	}
	
	public static String menu() {
	
		String aux = "";
		aux += "Escolha uma op��o:";
		aux += "\n1. Abrir conta";
		aux += "\n2. Realizar saque";
		aux += "\n3. Realizar dep�sito";
		aux += "\n4. Relat�rio de contas";
		aux += "\n5. Encerrar conta";
		aux += "\n6. Encerrar aplica��o";
		
		return aux;
	}
	

}
