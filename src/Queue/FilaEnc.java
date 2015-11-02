package Queue;

import SinglyLinkedList.NoSimpEnc;

public class FilaEnc<T> implements IFila<T> {
	private int contElementos;
	private NoSimpEnc<T> inicio, fim;
	
	private int pos;
	public FilaEnc() {
		inicio = new NoSimpEnc<>(null);
		fim = new NoSimpEnc<>(null);
	}
		
	@Override
	public void clear() {
		NoSimpEnc<T> atual = this.inicio;
		NoSimpEnc<T> aux = null;
		for (;atual != null; atual = aux) {
			aux = atual.getProximo();
			atual.setProximo(null);
		}
		atual = null;
		aux = null;
		this.inicio = null;
		this.fim = null;
		this.contElementos = 0;
	}

	@Override
	public int size() {
		return this.contElementos;
	}

	@Override
	public boolean isEmpty() {
		return this.contElementos == 0;
	}

	@Override
	public boolean contains(T elemento) {
		NoSimpEnc<T> no = this.inicio;
		for (int i = 0; i < this.contElementos; i++) {
			pos++;
			if (no.getElemento().equals(elemento))
				return true;
			no = no.getProximo();
		}
		return false;
	}

	@Override
	public int distance(T elemento) {
		int contador = 0;
		if (this.contains(elemento)) {
			NoSimpEnc<T> no = this.inicio;
			for (; no.getElemento() != elemento; no = no.getProximo()) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public T remove() {
		NoSimpEnc<T> no = new NoSimpEnc<>(null);
		if (this.contElementos > 0) {
			no = this.inicio;
			this.inicio = this.inicio.getProximo();
			this.contElementos--;
		}
		return no.getElemento();
	}

	@Override
	public void enqueue(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
		this.fim.setProximo(novoNo);
		this.fim = novoNo;
		this.fim.setProximo(this.inicio);
		if (this.contElementos == 0) {
			this.inicio = this.fim;
		}	
		this.contElementos++;
	}

	@Override
	public String toString() {
		if (this.contElementos == 0)
			return "[]";
		
		StringBuilder builder = new StringBuilder("[");
		NoSimpEnc<T> no = this.inicio;
		for (int i = 0; i < this.contElementos-1; i++) {
			builder.append(no.getElemento() + ",");
			no = no.getProximo();
		}
		builder.append(this.fim.getElemento());
		builder.append("]");
		
		return builder.toString();
	}
}
