package Hashtable;

import java.util.Iterator;

import SinglyLinkedList.ListaSimpEnc;
import SinglyLinkedList.NoSimpEnc;
import ArrayList.ListaVetor;

public class HashEnc<T> implements ITabelaHash<T>  {
	private int tamHash;
	private ListaVetor<ListaSimpEnc<T>> elementos;
	private int contElementos;
	private Iterator<T> iterator = new Iterator<T>() {

		int pos = 0;
		
		@Override
		public boolean hasNext() {
			if (pos < contElementos) {
				return true;
			} else {
				pos = 0;
				return false;
			}
		}

		@Override
		public T next() {
			NoSimpEnc<T> no = asList().getFirst();
			for (int i = 0; i < pos; i++) {
				no = no.getProximo();
			}
			pos++;
			return no.getElemento();
		}
		
	};
	
	public HashEnc() {
		this.tamHash = 11;
		this.elementos = new ListaVetor<ListaSimpEnc<T>>(tamHash, tamHash*2);
		this.contElementos = 0;
		
		for (int i = 0; i < this.tamHash; i++) {
			this.elementos.add(new ListaSimpEnc<>());
		}
	}
	
	@Override
	public void add(T elemento) {
		this.verifyLoadFactor();
		int indice = this.hash(elemento);
		this.elementos.get(indice).addLast(elemento);
		this.contElementos++;
	}

	@Override
	public void remove(T elemento) {
		int indice = this.hash(elemento);
		if (this.contains(elemento)) {
			this.elementos.get(indice).remover(elemento);
			this.contElementos--;
		}
	}

	@Override
	public boolean contains(T elemento) {
		int indice = this.hash(elemento);
		return this.elementos.get(indice).contains(elemento);
	}

	@Override
	public int hash(T elemento) {
		return Math.abs(elemento.hashCode() % this.tamHash);
	}

	@Override
	public int size() {
		return this.contElementos;
	}
	
	public int maxSize() {
		return this.tamHash;
	}

	@Override
	public ListaSimpEnc<T> asList() {
		ListaSimpEnc<T> lista = new ListaSimpEnc<>();
		
		for (int i = 0; i < this.tamHash; i++) {
			lista.InserirLista(this.elementos.get(i));
		}
		
		return lista;
	}

	@Override
	public void verifyLoadFactor() {
		double carga = (double) this.contElementos / this.tamHash;
		if (carga > 0.75) {
			this.resizeHashtable(tamHash * 2);
		}
	}

	@Override
	public void resizeHashtable(int novaCapacidade) {
		ListaSimpEnc<T> lista = this.asList();
		
		this.elementos.clear();
		this.contElementos = 0;
		
		for (int i = 0; i < novaCapacidade; i++) {
			this.elementos.add(new ListaSimpEnc<>());
		}
		
		for (T elemento : lista) {
			this.add(elemento);
		}
		
		this.tamHash = novaCapacidade;
	}
	
	public Iterator<T> iterator() {
		return this.iterator;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.tamHash; i++) {
			builder.append("{" + (i+1) + "}" + " ---> " + this.elementos.get(i)+"\n");
		}
		
		return builder.toString();
	}
}
