import java.util.ArrayList;
class No{
	int valor;
	No esquerdo;
	No direito;
	public No(){
		this.esquerdo = null;
		this.direito = null;
	}
}
public class Arvore{
	No raiz;
	public Arvore(){
		this.raiz = null;
	}
public No raiz(){
	return raiz;
}
public  boolean isEmpty(){
	return raiz == null;
}
public void isExternal(No x){
	if (x.esquerdo == null && x.direito == null){
		return false;
	} else{
		return true;
	}
}

public No buscar(int x, No no){
	if (no == null) {
		return null;
	}
	if (no.valor == x){
		return no;
	} 
	if (x < no.valor){
		return buscar(x, no.esquerdo);
	} else{
		return buscar(x,no.direito);
	}
}
public void preOrder(No noAtual){
	if (noAtual == null) return;
	System.out.println(noAtual.valor);
	preOrder(noAtual.esquerdo) // Esquerda
	preOrder(noAtual.direito) // Direita

}
public void inOrder(No noAtual){
	if (noAtual == null) return;
	inOrder(noAtual.esquerdo) // Esquerda
	System.out.println(noAtual.valor);
	inOrder(noAtual.direito) // Direita

}
public void postOrder(No noAtual){
	if (noAtual == null) return;
	postOrder(noAtual.esquerdo); // Esquerda
	postOrder(noAtual.direito); // Direta
	System.out.println(noAtual.valor);
}
public void inserir(Object x, No raiz){
	No novoNo = new No(){
		novoNo.valor = x;
		if (isEmpty()){
			raiz = novoNo;
		} else{
				No temp = raiz;
				while (temp != null){
					if (novoNo.valor < temp.valor){
						if (temp.esquerdo == null){
							temp.esquerdo = novoNo;
							break;
						} else{
							temp = temp.esquerdo;
						}
					} else{
						if (temp.direito == null){
							temp.direito = novoNo;
							break;
						} else{
							temp = temp.direito;
						}
					}
				}
		}
	}
}
public void remover(Object x){

}
}