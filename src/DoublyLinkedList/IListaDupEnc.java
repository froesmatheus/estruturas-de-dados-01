package DoublyLinkedList;

import java.util.Iterator;

public interface IListaDupEnc<T> {
	// Retorna a referencia do no que encontra-se no inicio da lista
	public NoDupEnc<T> getFirst();

	// Retorna a referencia do no que encontra-se no fim da lista
	public NoDupEnc<T> getLast();

	// Limpa toda a lista
	public void clear();

	// size de elementos que a lista possui
	public int size();

	// Retorna se a lista est� ou nao vazia
	public boolean isEmpty();

	// add um elemento no inicio da lista
	public void addFirst(T elemento);

	// add um elemento no fim da lista
	public void addLast(T elemento);

	// add um elemento na posicao indicada pelo parametro pos
	public void add(int pos, T elemento);

	// Indica se a lista possui o elemento
	public boolean contains(T elemento);

	// Remove o primeiro elemento da lista
	public void removeFirst();

	// Remove o �ltimo elemento da lista
	public void removeLast();

	// Remove o elemento na posicao
	public void remove(int pos);

	public String toString();

	//Percorre o iterator ao contrario
	public Iterator<T> iterator();
}

