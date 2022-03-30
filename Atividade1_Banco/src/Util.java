import javax.swing.JOptionPane;

public class Util {
	
	static Lista<Conta> lista = new Lista<Conta>();
	

	public static void abrirConta() {
		String nome;
		String cpf;
		
		cpf = JOptionPane.showInputDialog("Informe o seu cpf: ");
		
		Conta conta = new Conta(cpf, null);
		
		if(lista.pesquisar(conta) != null) {
			
			JOptionPane.showMessageDialog(null, "CPF existente!");
			
		} else {
			nome = JOptionPane.showInputDialog("Informe o seu nome: ");
		
			Conta conta_lista = new Conta(cpf, nome);
			lista.inserir(conta_lista);
		}		
	}

	public static void realizarSaque() {
		Conta conta = informarCpf();
		
		No aux = lista.pesquisar(conta);
	
		if(lista.pesquisar(conta) != null) {
			Conta x = (Conta)aux.dado;
			double valor;
			valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de saque (R$) : "));
			
			if (x.verificarSaldo(valor)) {
				x.sacar(valor);
				
				JOptionPane.showMessageDialog(null, "R$ " + valor + "\nSaque realizdo com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro! Saldo insuficiente :(");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "CPF inexistente!");
		}		
	}

	public static void realizarDeposito() {
	
		Conta conta = informarCpf();
		
		No aux = lista.pesquisar(conta);
		
		
		if(lista.pesquisar(conta) != null) {
			
			Conta x = (Conta)aux.dado;
			double valor;
			valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de depósito (R$) : "));
		
			x.depositar(valor);
			
			JOptionPane.showMessageDialog(null, "R$ " + valor + "\nDepósito realizdo com sucesso!");
			
			
		} else {
			JOptionPane.showMessageDialog(null, "CPF inexistente!");
		}		
		
	}

	public static void relatorioContas() {
		lista.imprimir();
	}

	public static void encerrarConta() {
		
		Conta conta = informarCpf();
		
		if(lista.pesquisar(conta) != null) {
			
			lista.remover(conta);
			JOptionPane.showMessageDialog(null, "Conta encerrada :)");
			
		} else {
			JOptionPane.showMessageDialog(null, "CPF inexistente!");
		}	
		
	}
	
	public static Conta informarCpf() {
		String cpf;
		
		cpf = JOptionPane.showInputDialog("Informe o seu cpf: ");
		
		Conta conta = new Conta(cpf, null);
		
		return conta;
	}
	
}