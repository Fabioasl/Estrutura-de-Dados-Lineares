class No{
	Object element;
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
public remover (Object x){

}
public void buscar(Object x, No raiz){

}
public void preOrder(No noAtual){

}
public void inOrder(No noAtual){

}
public void postOrder(No no Atual){

}
public void inserir(Object x, No raiz){
	No novoNo = new No(){
		novoNo.element = x;
		if (isEmpty()){
			raiz = novoNo;
		} else{
				No temp = raiz;
				while (temp != null){
					if (novoNo.element < temp.element){
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