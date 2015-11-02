package Stack;

import SinglyLinkedList.NoSimpEnc;

public class PilhaEncadeada<T> implements IPilha<T> {
	private NoSimpEnc<T> topo;
	private int contElementos, pos;

	public PilhaEncadeada() {
		topo = new NoSimpEnc<>(null);
	}

	@Override
	public T peek() {
		if (this.contElementos > 0) {
			return this.topo.getElemento();
		}
		return null;
	}

	@Override
	public void clear() {
		NoSimpEnc<T> atual = this.topo;
		NoSimpEnc<T> aux = null;
		for (;atual != null; atual = aux) {
			aux = atual.getProximo();
			atual.setProximo(null);
		}
		atual = null;
		aux = null;
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
		NoSimpEnc<T> atual = topo;
		for (int i = 0; i < contElementos; i++) {
			if (atual.getElemento().equals(elemento)) {
				this.pos = i;
				return true;
			} 
			atual = atual.getProximo();
		}
		return false;
	}

	@Override
	public int distance(T elemento) {
		int contador = -1;
		if (this.contains(elemento)) {
			for (int i = pos; i >= 0; i--) {
				contador++;
			}
		}
		return contador;
		
	}

	@Override
	public T pop() {
		if (this.contElementos > 0) {
			NoSimpEnc<T> info = topo;
			topo = topo.getProximo();
			this.contElementos--;
			return info.getElemento();
		}
		return null;
	}

	@Override
	public void push(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<>(elemento);
		novoNo.setProximo(topo);
		topo = novoNo;
		this.contElementos++;
	}

	@Override
	public String toString() {
		if (this.contElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoSimpEnc<T> no = topo;
		for (int i = this.contElementos; i > 1; i--) {
			builder.append(no.getElemento() + ",");
			no = no.getProximo();
		}
		builder.append(no.getElemento());
		builder.append("]");
		return builder.toString();
	}

}
