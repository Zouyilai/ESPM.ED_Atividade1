import javax.swing.JOptionPane;

public class Lista<T>{
	
	No<T> inicio, fim;
	int total;
	
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado); 
		
		if(total == 0) {
			inicio = aux;
		} else {
			fim.dir = aux;
			aux.esq = fim;
		}
		
		fim = aux;
		total ++;
	}
	
	//método para pesquisar um elemento e retornar o endereço de memória
	public No<T> pesquisar(T dado) {
		No<T> aux = inicio;
		boolean achou = false;
		while(aux != null && achou == false) {
			if(aux.dado.equals(dado)) {
				achou = true;
				break;
			} 
			aux = aux.dir; 
			
		}
		return aux;
	}
	
	
	//método para remover um elemento da lista
	public void remover(T dado) {
		No<T> aux = pesquisar(dado);
		
		if(aux != null) {
			if(total == 1) {//caso tenha um único elemento
				inicio = null;
				fim = null;	
			} else if(aux == inicio) { //primeiro elemento
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if(aux == fim){//último elemento
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {//elemento do meio
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
			
			total--;
		}
	}
	
	public void imprimir() {
		No<T> aux = inicio;
		String aux2 = "";
		while(aux != null) {
			aux2 += aux.dado;
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, aux2);
	}
}


