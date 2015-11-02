package DoublyLinkedList;

import java.util.Iterator;

public class ListaDupEnc<T> implements IListaDupEnc<T> {
	private NoDupEnc<T> noCabeca;
	private int contElementos;

	private Iterator<T> iterator = new Iterator<T>() {

		private int posicao = 0;

		@Override
		public boolean hasNext() {
			if (posicao < contElementos) {
				return true;
			} else {
				posicao = 0;
				return false;
			}
		}

		@Override
		public T next() {
			NoDupEnc<T> no = noCabeca.getAnterior();
			for (int i = 0; i < posicao; i++) {
				no = no.getProximo();
			}
			posicao++;
			return no.getElemento();
		}

	};

	public ListaDupEnc() {
		this.noCabeca = new NoDupEnc<>(null);
		this.contElementos = 0;
	}

	@Override
	public NoDupEnc<T> getFirst() {
		return this.noCabeca.getAnterior();
	}

	@Override
	public NoDupEnc<T> getLast() {
		return this.noCabeca.getProximo();
	}

	@Override
	public void clear() {
		NoDupEnc<T> atual = noCabeca.getAnterior();
		NoDupEnc<T> aux = new NoDupEnc<>(null);
		for (; atual != null; atual = aux) {
			aux = atual.getProximo();
			atual.setAnterior(null);
			atual.setProximo(null);
		}
		aux = null;
		atual = null;
		noCabeca.setAnterior(null);
		noCabeca.setProximo(null);
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
	public void addFirst(T elemento) {
		NoDupEnc<T> novo = new NoDupEnc<>(elemento);
		if (this.contElementos == 0) {
			novo.setProximo(null);
			novo.setAnterior(null);
			this.noCabeca.setAnterior(novo);
			this.noCabeca.setProximo(novo);
		} else {
			NoDupEnc<T> atual = noCabeca.getAnterior();
			atual.setAnterior(novo);
			novo.setProximo(atual);
			novo.setAnterior(null);
			this.noCabeca.setAnterior(novo);
		}
		contElementos++;
	}

	@Override
	public void addLast(T elemento) {
		NoDupEnc<T> novo = new NoDupEnc<>(elemento);
		if (this.contElementos == 0) {
			this.addFirst(elemento);
		} else {
			NoDupEnc<T> atual = noCabeca.getProximo();
			atual.setProximo(novo);
			novo.setAnterior(atual);
			novo.setProximo(null);
			this.noCabeca.setProximo(novo);
			contElementos++;
		}
	}

	@Override
	public void add(int pos, T elemento) {
		NoDupEnc<T> no = this.noCabeca.getAnterior();
		NoDupEnc<T> novoNo = new NoDupEnc<>(elemento);

		if (pos > contElementos + 1 || pos <= 0) {
			throw new IllegalArgumentException("Posi��o inv�lida!");
		}

		if (pos == 1) {
			this.addFirst(elemento);
		} else if (pos == contElementos + 1) {
			this.addLast(elemento);
		} else {
			for (int i = 1; i < pos - 1; i++) {
				no = no.getProximo();
			}
			novoNo.setProximo(no.getProximo());
			novoNo.setAnterior(no);
			no.getProximo().setAnterior(novoNo);
			no.setProximo(novoNo);
			contElementos++;
		}
	}

	// Método da prova
	public void reverseList() {
		if (this.contElementos > 1) {
			NoDupEnc<T> fim = this.noCabeca.getProximo();
			NoDupEnc<T> inicio = this.noCabeca.getAnterior();
			T aux;

			aux = fim.getElemento();
			int cont;
			if (contElementos % 2 == 0) {
				cont = contElementos / 2;
			} else {
				cont = (contElementos + 1) / 2;
			}
			for (int i = 0; i < cont; i++) {
				fim.setElemento(inicio.getElemento());
				fim = fim.getAnterior();
				inicio.setElemento(aux);
				aux = fim.getElemento();
				inicio = inicio.getProximo();
			}
		}
	}

	@Override
	public boolean contains(T elemento) {
		NoDupEnc<T> atual = this.noCabeca.getAnterior();
		for (; atual != null; atual = atual.getProximo()) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeFirst() {
		NoDupEnc<T> inicio = this.noCabeca.getAnterior();

		if (this.contElementos == 0) {
			throw new IllegalArgumentException("Posição inválida");
		}

		if (this.contElementos == 1) {
			this.noCabeca.setAnterior(null);
			this.noCabeca.setProximo(null);
		} else if (this.contElementos >= 1) {
			this.noCabeca.setAnterior(inicio.getProximo());
			inicio.getProximo().setAnterior(null);
			inicio = null;
		}
		this.contElementos--;
	}

	@Override
	public void removeLast() {
		NoDupEnc<T> fim = this.noCabeca.getProximo();

		if (this.contElementos == 0) {
			throw new IllegalArgumentException("Posição inválida");
		}

		if (this.contElementos == 1) {
			this.removeFirst();
		} else if (this.contElementos > 1) {
			this.noCabeca.setProximo(fim.getAnterior());
			fim.getAnterior().setProximo(null);
			fim = null;
			contElementos--;
		}
	}

	// Bubble Sort - Método da Prova
	@SuppressWarnings("unchecked")
	public void bubbleSort() {
		if (this.contElementos > 1) {
			NoDupEnc<T> atual = this.noCabeca.getAnterior();
			NoDupEnc<T> prox = atual.getProximo();
			NoDupEnc<T> aux = new NoDupEnc<>(null);
			for (int i = 0; i < this.contElementos - 1; i++) {
				for (int j = 0; j < this.contElementos - 1; j++) {
					if (((Comparable<T>) atual.getElemento()).compareTo(prox
							.getElemento()) > 0) {
						aux.setElemento(atual.getElemento());
						atual.setElemento(prox.getElemento());
						prox.setElemento(aux.getElemento());
					}
					atual = atual.getProximo();
					prox = atual.getProximo();
				}
				atual = this.noCabeca.getAnterior();
				prox = atual.getProximo();
			}
		}
	}

	// Selection Sort
	@SuppressWarnings("unchecked")
	public void selectionSort() {
		if (this.contElementos > 1) {
			NoDupEnc<T> noAtual = this.noCabeca.getAnterior();
			NoDupEnc<T> noIt = noAtual.getProximo();
			NoDupEnc<T> menor = noAtual;
			for (int i = 0; i < this.contElementos - 1; i++) {
				menor = noAtual;
				for (int j = i; j < this.contElementos - 1; j++) {
					if (((Comparable<T>) noIt.getElemento()).compareTo(menor
							.getElemento()) < 0) {
						menor = noIt;
					}
					noIt = noIt.getProximo();
				}
				if (menor != null) {
					T valorAtual = noAtual.getElemento();
					noAtual.setElemento(menor.getElemento());
					menor.setElemento(valorAtual);
				}
				menor = null;
				noAtual = noAtual.getProximo();
				noIt = noAtual.getProximo();
			}
		}
	}

	// Insertion Sort
	@SuppressWarnings("unchecked")
	public void insertionSort() {
		if (this.contElementos > 1) {
			NoDupEnc<T> no = this.noCabeca.getAnterior();
			NoDupEnc<T> prox = no.getProximo();
			NoDupEnc<T> holder = new NoDupEnc<>(null);
			NoDupEnc<T> pontNo = this.noCabeca.getAnterior();

			for (int i = 0; i < this.contElementos - 1; i++) {
				if (((Comparable<T>) no.getElemento()).compareTo(prox
						.getElemento()) > 0) {
					holder.setElemento(no.getElemento());
					no.setElemento(no.getProximo().getElemento());
					prox.setElemento(holder.getElemento());
				}

				for (int j = 0; j < i; j++) {
					if (((Comparable<T>) pontNo.getElemento()).compareTo(no
							.getElemento()) > 0) {
						T a = pontNo.getElemento();
						pontNo.setElemento(no.getElemento());
						no.setElemento(a);
					}
					pontNo = pontNo.getProximo();
				}
				pontNo = this.noCabeca.getAnterior();
				no = no.getProximo();
				prox = no.getProximo();
			}
		}
	}

	// Quick Sort
	public void quickSort() {
		if (this.contElementos > 1) {
			this.quickSort(1, this.contElementos);
		}
	}

	private void quickSort(int inicio, int fim) {
		int pivo;
		if (inicio < fim) {
			pivo = this.particao(inicio, fim);
			quickSort(inicio, pivo);
			quickSort(pivo + 1, fim);
		}
	}

	@SuppressWarnings("unchecked")
	private int particao(int ini, int fim) {
		T elemPivo = this.get(ini).getElemento();
		NoDupEnc<T> posPivo = this.get(ini);
		NoDupEnc<T> prox = posPivo.getProximo();
		int index = ini;

		for (int i = ini; i < fim; i++) {
			if (((Comparable<T>) prox.getElemento()).compareTo(elemPivo) < 0) {
				posPivo.setElemento(prox.getElemento());
				prox.setElemento(posPivo.getProximo().getElemento());
				index++;
				posPivo = posPivo.getProximo();
			}
			prox = prox.getProximo();
		}
		posPivo.setElemento(elemPivo);
		return index;
	}

	public NoDupEnc<T> get(int indice) {
		NoDupEnc<T> no = this.noCabeca.getAnterior();
		for (int i = 0; i < indice - 1; i++) {
			no = no.getProximo();
		}
		return no;
	}

	@Override
	public void remove(int pos) {
		NoDupEnc<T> elementoAnterior = null;
		NoDupEnc<T> elementoSucessor = null;

		if (pos > contElementos || pos <= 0) {
			throw new IllegalArgumentException("Posição inválida!");
		}

		if (pos == 1) {
			this.removeFirst();
		} else if (pos == this.contElementos) {
			this.removeLast();
		} else {
			elementoAnterior = this.noCabeca.getAnterior();
			for (int i = 0; i < pos - 2; i++) {
				elementoAnterior = elementoAnterior.getProximo();
			}
			elementoSucessor = elementoAnterior.getProximo().getProximo();
			elementoAnterior.setProximo(elementoSucessor);
			elementoSucessor.setAnterior(elementoAnterior);
			this.contElementos--;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

	public void addInOrder(T elemento) {
		boolean adicionou = false;
		NoDupEnc<T> no = noCabeca.getAnterior();
		if (!this.contains(elemento)) {
			if (this.contElementos == 0) {
				this.addLast(elemento);
			} else {
				int pos = 1;
				String elementoLista = no.getElemento() + "";
				for (int i = 1; i <= this.contElementos; i++) {
					if (elemento.toString().compareToIgnoreCase(elementoLista) < 0) {
						pos = i;
						this.add(pos, elemento);
						adicionou = true;
						break;
					}
					no = no.getProximo();
					if (no == null) {
						break;
					}
					elementoLista = no.getElemento() + "";
				}
				if (!adicionou) {
					this.addLast(elemento);
				}
			}
		}
	}

	@Override
	public String toString() {
		if (this.contElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoDupEnc<T> atual = noCabeca.getAnterior();
		for (int i = 0; i < contElementos - 1; i++) {
			builder.append(atual.getElemento() + ",");
			atual = atual.getProximo();
		}
		builder.append(noCabeca.getProximo().getElemento());
		builder.append("]");
		return builder.toString();
	}

}
