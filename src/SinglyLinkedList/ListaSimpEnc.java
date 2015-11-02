package SinglyLinkedList;

import java.util.Iterator;

public class ListaSimpEnc<T> implements IListaSimpEnc<T>, Iterable<T> {
	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private int contElementos;
	private int pos;

	private Iterator<T> iterator = new Iterator<T>() {

		private int pos = 0;

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
			NoSimpEnc<T> no = inicio;
			for (int i = 0; i < pos; i++) {
				no = no.getProximo();
			}
			pos++;
			return no.getElemento();
		}
	};

	@Override
	public NoSimpEnc<T> getFirst() {
		return this.inicio;
	}

	@Override
	public NoSimpEnc<T> getLast() {
		return this.fim;
	}

	@Override
	public void clear() {
		NoSimpEnc<T> atual = this.inicio;
		NoSimpEnc<T> aux = null;
		for (; atual != null; atual = aux) {
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
	public void addFirst(T elemento) {
		NoSimpEnc<T> nova = new NoSimpEnc<>(elemento, this.inicio);
		this.inicio = nova;

		if (this.contElementos == 0) {
			this.fim = this.inicio;
		}

		this.contElementos++;
	}

	@Override
	public void addLast(T elemento) {
		if (this.contElementos == 0) {
			this.addFirst(elemento);
		} else {
			NoSimpEnc<T> nova = new NoSimpEnc<>(elemento);
			this.fim.setProximo(nova);
			this.fim = nova;
			this.fim.setProximo(null);
			this.contElementos++;
		}
	}

	// Método da prova
	public boolean listasIguais(ListaSimpEnc<T> lista1, ListaSimpEnc<T> lista2) {
		if (lista1.size() == lista2.size()) {
			if (lista1.size() == 0) {
				return true;
			}

			if (lista1.getFirst().getElemento() == lista2.getFirst()
					.getElemento()) {
				lista1.removeFirst();
				lista2.removeFirst();
				return listasIguais(lista1, lista2);
			}
		}
		return false;
	}

	public NoSimpEnc<T> get(int indice) {
		NoSimpEnc<T> no = this.inicio;
		for (int i = 0; i < indice - 1; i++) {
			no = no.getProximo();
			pos++;
		}
		return no;
	}

	@Override
	public void add(int pos, T elemento) {
		if (pos > contElementos + 1 || pos <= 0) {
			throw new IndexOutOfBoundsException("Posição não existe!");
		}

		if (pos == 1) {
			this.addFirst(elemento);
		} else if (pos == this.contElementos + 1) {
			this.addLast(elemento);
		} else {
			NoSimpEnc<T> anterior = this.getNo(pos - 1);
			NoSimpEnc<T> nova = new NoSimpEnc<T>(elemento);
			nova.setProximo(anterior.getProximo());
			anterior.setProximo(nova);
			this.contElementos++;
		}
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 1 && posicao <= this.contElementos + 1;
	}

	private NoSimpEnc<T> getNo(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IndexOutOfBoundsException("Posição inválida!");
		}

		NoSimpEnc<T> atual = inicio;
		for (int i = 0; i < posicao - 1; i++) {
			atual = atual.getProximo();
		}

		return atual;
	}

	@Override
	public boolean contains(T elemento) {
		NoSimpEnc<T> atual = inicio;
		for (int i = 0; i < contElementos; i++) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}
	
	// Método da prova - Segunda Unidade	
	public ListaSimpEnc<T> concatenarOrdenado(ListaSimpEnc<T> lista) {
		ListaSimpEnc<T> list = new ListaSimpEnc<T>();

		list.InserirLista(this);
		list.InserirLista(lista);
		
		list.QuickSort();
		
		return list;
	}
	
	
	@Override
	public void removeFirst() {
		if (this.contElementos == 0) {
			throw new IllegalArgumentException("Posição não existe!");
		}

		this.inicio = this.inicio.getProximo();
		this.contElementos--;

		if (this.contElementos == 0) {
			this.fim = null;
		}
	}

	// Selection Sort
	@SuppressWarnings("unchecked")
	public void SelectionSort() {
		if (this.contElementos > 1) {
			NoSimpEnc<T> noAtual = this.inicio;
			NoSimpEnc<T> noIt = this.inicio.getProximo();
			NoSimpEnc<T> menor = noAtual;
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

	// Bubble Sort
	@SuppressWarnings("unchecked")
	public void BubbleSort() {
		if (this.contElementos > 1) {
			NoSimpEnc<T> no = this.inicio;
			NoSimpEnc<T> prox = this.inicio.getProximo();
			for (int i = 0; i < this.contElementos - 1; i++) {
				for (int j = 0; j < this.contElementos - 1; j++) {
					if (((Comparable<T>) no.getElemento()).compareTo(prox
							.getElemento()) > 0) {
						NoSimpEnc<T> aux = new NoSimpEnc<>(null);
						aux.setElemento(no.getElemento());
						no.setElemento(prox.getElemento());
						prox.setElemento(aux.getElemento());
					}

					no = no.getProximo();
					prox = prox.getProximo();
				}

				no = this.inicio;
				prox = no.getProximo();
			}
		}
	}

	// Insertion Sort
	@SuppressWarnings("unchecked")
	public void InsertionSort() {
		if (this.contElementos > 1) {
			NoSimpEnc<T> no = this.inicio;
			NoSimpEnc<T> prox = no.getProximo();
			NoSimpEnc<T> holder = new NoSimpEnc<>(null);
			NoSimpEnc<T> pontNo = this.inicio;

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
				pontNo = this.inicio;
				no = no.getProximo();
				prox = no.getProximo();
			}
		}
	}

	// Quick Sort
	public void QuickSort() {
		if (this.contElementos > 1) {
			this.QuickSort(1, this.contElementos);
		}
	}

	private void QuickSort(int inicio, int fim) {
		int pivo;
		if (inicio < fim) {
			pivo = this.particao(inicio, fim);
			QuickSort(inicio, pivo);
			QuickSort(pivo + 1, fim);
		}
	}

	@SuppressWarnings("unchecked")
	private int particao(int ini, int fim) {
		T elemPivo = this.get(ini).getElemento();
		NoSimpEnc<T> posPivo = this.get(ini);
		NoSimpEnc<T> prox = posPivo.getProximo();
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

	// Quick Sort com Nó
	public void QuickSort(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
		NoSimpEnc<T> pivo;
		if (ini != null && ini != fim) {
			pivo = particao(ini, fim);
			QuickSort(ini, pivo);
			QuickSort(pivo.getProximo(), fim);
		}
	}

	@SuppressWarnings("unchecked")
	public NoSimpEnc<T> particao(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
		NoSimpEnc<T> pivo = ini;
		T elemPivo = ini.getElemento();
		do {
			if (ini.getProximo() != null) {
				ini = ini.getProximo();
				if (((Comparable<T>) ini.getElemento()).compareTo(elemPivo) < 0) {
					pivo.setElemento(ini.getElemento());
					ini.setElemento(pivo.getProximo().getElemento());
					if (pivo.getProximo() != null) {
						pivo = pivo.getProximo();
					}
				}
			}
		} while (ini != fim);

		pivo.setElemento(elemPivo);
		return pivo;
	}

	public ListaSimpEnc<T> subLista(int indiceInicial, int indiceFinal) {
		if (indiceInicial < 1 || indiceInicial > contElementos
				|| indiceFinal < 1 || indiceFinal > contElementos) {
			throw new IndexOutOfBoundsException("Posição inválida!");
		}

		ListaSimpEnc<T> lista = new ListaSimpEnc<>();
		NoSimpEnc<T> noInicio = inicio;
		for (int i = 0; i < indiceInicial - 1; i++) {
			noInicio = noInicio.getProximo();
		}

		for (int i = indiceInicial; i < indiceFinal - 1; i++) {
			noInicio = noInicio.getProximo();
			lista.addLast(noInicio.getElemento());
		}
		return lista;
	}

	public int getIndex(NoSimpEnc<T> no) {
		int cont = 0;
		NoSimpEnc<T> noAux = this.inicio;
		for (int i = 0; i < this.contElementos; i++) {
			if (noAux.equals(no)) {
				cont = i;
			}
			noAux = noAux.getProximo();
		}
		return cont;
	}

	@Override
	public void removeLast() {
		if (this.contElementos == 0) {
			throw new IllegalArgumentException("Posição não existe!");
		} else if (this.contElementos == 1) {
			this.removeFirst();
		} else if (this.contElementos > 1) {
			NoSimpEnc<T> anterior = this.getNo(contElementos - 1);
			anterior.setProximo(null);
			this.fim = anterior;
			contElementos--;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

	public void InserirLista(ListaSimpEnc<T> lista) {
		NoSimpEnc<T> no = lista.getFirst();
		for (int i = 0; i < lista.size(); i++) {
			this.addLast(no.getElemento());
			no = no.getProximo();
		}
	}

	public Object[] toArray() {
		if (this.contElementos > 0) {
			Object array[] = new Object[this.contElementos];
			NoSimpEnc<T> no = this.inicio;
			for (int i = 0; i < this.contElementos; i++) {
				array[i] = no.getElemento();
				no = no.getProximo();
			}
			return array;
		}
		return new Object[0];		
	}
	
	public void remover(T elemento) {
		NoSimpEnc<T> no = this.inicio;
		if (this.contains(elemento)) {
			if (this.inicio.getElemento().equals(elemento)) {
				this.removeFirst();
			} else if (this.fim.getElemento().equals(elemento)) {
				this.removeLast();
			} else {
				for (int i = 0; i < this.contElementos - 2; i++) {
					if (no.getProximo().getElemento().equals(elemento)) {
						NoSimpEnc<T> procurado = no.getProximo();
						no.setProximo(procurado.getProximo());
						procurado.setElemento(null);
						procurado.setProximo(null);
						procurado = null;
					}

					no = no.getProximo();
				}
				this.contElementos--;

			}
		}
	}

	@Override
	public String toString() {
		if (this.contElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 0; i < this.contElementos - 1; i++) {
			builder.append(atual.getElemento() + ",");
			atual = atual.getProximo();
		}
		builder.append(this.fim.getElemento());
		builder.append("]");
		return builder.toString();
	}
}