public class Conta {
	String cpf;
	String nome;
	double saldo;
	
	
	public Conta(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	
	
	@Override
	public String toString() {
		String dados = "";
		dados += "Nome  -> " + nome + "\n";
		dados += "CPF   -> " + cpf + "\n";
		dados += "Saldo -> R$ " + saldo + "\n";
		dados += "-----------" + "\n";
		return dados;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Conta aux = (Conta) obj; 
		
		if(aux.cpf.equals(cpf)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean verificarSaldo(double valor) {
		boolean menor = true;
		
		if(saldo < valor) {
			menor = false;
		}
		return menor;
	}
	
	public boolean verificarValor(double valor) {
		boolean negativo = true;
		
		if (valor > 0) {
			negativo = false;
		}
		return negativo;
	}
	
	public void sacar (double valor) {
		saldo = saldo - valor;
	}
	
	public void depositar (double valor) {
		saldo = saldo + valor;
	}
	
}
