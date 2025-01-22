import java.util.*;
public class FilaPriodaideArray{
    private int size;
    private int occupied;
    private Object[] array;
    public FilaPriodaideArray(int size){
        this.size = size;
        this.occupied = 0;
        array = new Object[size]
    }
public int leftChild(int parent){
        return parent * 2 + 1;
}
public int rightChild(int parent){
    return parent * 2 + 1;
}

public int size(){
    return this.size;
}
public boolean isEmpty(){
    return size == 0;
}
public int min(){
    return array[1];
}
public void removeMin(){
    int temp = array[1]; 
    array[1] = array[occupied];
    array[occupied] = temp;
    this.size--;
    this.occupied--;

    // falta o uphead e  o downheap
}
public void insert(Object a){
    if (this.occupied == this.size) aumenta_cap(){
    array[size - 1] = a; 
    this.size++;
    this.occupied++;
}
public void aumenta_cap(){
        this.size *=2;
        Object [] novo_array = new Object[size*=2];
        for (int i = 0; i < array.length();i++){
            novo_array[i] = array[i]
        }
        array = novo_array;
}
}