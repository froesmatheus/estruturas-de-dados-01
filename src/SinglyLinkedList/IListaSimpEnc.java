package SinglyLinkedList;

import java.util.Iterator;

public interface IListaSimpEnc<T> {
	// Retorna a referencia do n� que encontra-se no inicio da lista
	public NoSimpEnc<T> getFirst();

	// Retorna a referencia do n� que encontra-se no fim da lista
	public NoSimpEnc<T> getLast();

	// Limpa toda a lista
	public void clear();

	// size de elementos que a lista possui
	public int size();

	// Retorna se a lista esta ou nao vazia
	public boolean isEmpty();

	// add um elemento no inicio da lista
	public void addFirst(T elemento);

	// add um elemento no fim da lista
	public void addLast(T elemento);

	// add um elemento na positivo indicada pelo parametro pos
	public void add(int pos, T elemento);

	// Indica se a lista possui o elemento
	public boolean contains(T elemento);

	// Remove o primeiro elemento da lista
	public void removeFirst();

	// Remove o ultimo elemento da lista
	public void removeLast();

	// toString
	public String toString();

	// Iterator
	public Iterator<T> iterator();
}
