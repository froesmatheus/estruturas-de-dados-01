package ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ListaVetor<T> implements IVetor<T>, Iterable<T> {
	private final int tamVet;
	private T[] elementos;
	private int contElementos;
	private int vlIncremento;

	private int pos = 0;

	private Iterator<T> iterator = new Iterator<T>() {

		private int posicao = 0;

		@Override
		public boolean hasNext() {
			if (posicao < contElementos) {
				return true;
			} else
				posicao = 0;
			return false;
		}

		public T next() {
			if (posicao > contElementos) {
				throw new NoSuchElementException();
			} else {
				T elemento = elementos[posicao];
				posicao++;
				return elemento;
			}
		}
	};

	public ListaVetor() {
		tamVet = 10;
		elementos = (T[]) new Object[tamVet];
		contElementos = 0;
		vlIncremento = 10;
	}

	public ListaVetor(int tamVetor) {
		tamVet = tamVetor;
		elementos = (T[]) new Object[tamVet];
		contElementos = 0;
		vlIncremento = 10;
	}

	public ListaVetor(int tamVetor, int incremento) {
		tamVet = tamVetor;
		elementos = (T[]) new Object[tamVet];
		contElementos = 0;
		vlIncremento = incremento;
	}

	@Override
	public void add(T elemento) {
		boolean temEspaco = this.verificarCapacidade();
		if (temEspaco) {
			elementos[contElementos] = elemento;
		} else {
			this.redimensionarVetor();
			elementos[contElementos] = elemento;
		}
		contElementos++;
	}

	@Override
	public void add(int posicao, T elemento)
			throws IndexOutOfBoundsException {
		if (posicao > contElementos || posicao < 0) {
			throw new IndexOutOfBoundsException("Posi��o inv�lida!");
		}

		if (verificarCapacidade()) {
			this.adicionarAux(posicao, elemento);
		} else {
			this.redimensionarVetor();
			this.adicionarAux(posicao, elemento);
		}
	}

	private void adicionarAux(int posicao, T elemento) {
		for (int i = contElementos - 1; i >= posicao; i--) {
			elementos[i + 1] = elementos[i];
		}
		elementos[posicao] = elemento;
		contElementos++;
	}

	@Override
	public void addFirst(T elemento) {
		this.add(0, elemento);
	}

	@Override
	public void remove(int posicao) throws ArrayIndexOutOfBoundsException {
		if (posicao >= contElementos || posicao < 0) {
			throw new ArrayIndexOutOfBoundsException("Posi��o inv�lida!");
		}

		elementos[posicao] = null;
		for (int i = posicao; i < contElementos - 1; i++) {
			elementos[i] = elementos[i + 1];
		}
		contElementos--;
	}

	@Override
	public void remove(T elemento) {
		if (contains(elemento)) {
			remove(pos);
		}
	}

	@Override
	public void removeFirst() throws ArrayIndexOutOfBoundsException {
		this.remove(0);
	}

	@Override
	public void removeLast() {
		remove(contElementos - 1);
	}

	@Override
	public int size() {
		return contElementos;
	}

	@Override
	public void clear() {
		for (int i = 0; i < contElementos; i++) {
			elementos[i] = null;
		}
		contElementos = 0;
	}

	public void removeRepeated() {
		int contador = 0;
		for (int i = 0; i < contElementos; i++) {
			for (int j = 0; j < contElementos; j++) {
				if (elementos[i].equals(elementos[j])) {
					contador++;
					if (contador > 1) {
						this.remove(j);
						j--;
					}
				}
			}
			contador = 0;
		}
	}

	@Override
	public boolean contains(T elemento) {
		for (int i = 0; i < contElementos; i++) {
			if (elementos[i].equals(elemento)) {
				pos = i;
				return true;
			}
		}
		return false;
	}

	// Bubble Sort
	public void bubbleSort() {
		for (int i = 0; i < this.contElementos - 1; i++) {
			for (int j = 0; j < this.contElementos - 1; j++) {
				if (((Comparable<T>) elementos[j]).compareTo(elementos[j + 1]) > 0) {
					T aux = elementos[j];
					elementos[j] = elementos[j + 1];
					elementos[j + 1] = aux;
				}
			}
		}
	}

	// Selection Sort
	public void selectionSort() {
		int pos = 0;
		for (int i = 0; i < this.contElementos; i++) {
			T menor = this.elementos[i];
			pos = i;
			for (int j = i + 1; j < this.contElementos; j++) {
				if (((Comparable<T>) this.elementos[j]).compareTo(menor) < 0) {
					menor = elementos[j];
					pos = j;
				}
			}
			T aux = this.elementos[i];
			this.elementos[i] = menor;
			this.elementos[pos] = aux;
		}
	}

	// Insertion Sort
	public void insertionSort() {
		for (int i = 0; i < this.contElementos - 1; i++) {
			if (((Comparable<T>) this.elementos[i])
					.compareTo(this.elementos[i + 1]) > 0) {
				T aux = this.elementos[i];
				this.elementos[i] = this.elementos[i + 1];
				this.elementos[i + 1] = aux;
			}
			for (int j = 0; j < i; j++) {
				if (((Comparable<T>) this.elementos[j])
						.compareTo(this.elementos[i]) > 0) {
					T aux = this.elementos[j];
					this.elementos[j] = this.elementos[i];
					this.elementos[i] = aux;
				}
			}
		}
	}

	// Quick Sort
	public void quickSort() {
		this.quickSort(0, this.contElementos);
	}

	private void quickSort(int ini, int fim) {
		int pivo;
		if (ini < fim) {
			pivo = particao(ini, fim);
			quickSort(ini, pivo);
			quickSort(pivo + 1, fim);
		}
	}

	private int particao(int ini, int fim) {
		T pivo = this.elementos[ini];
		int posPivo = ini;
		for (int i = ini + 1; i < fim; i++) {
			if (((Comparable<T>) this.elementos[i]).compareTo(pivo) < 0) {
				elementos[posPivo] = elementos[i];
				elementos[i] = elementos[posPivo + 1];
				posPivo++;
			}
		}
		this.elementos[posPivo] = pivo;
		return posPivo;
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

	private void redimensionarVetor() {
		T[] lista = (T[]) new Object[elementos.length + vlIncremento];
		System.arraycopy(elementos, 0, lista, 0, contElementos);
		elementos = lista;
	}

	private boolean verificarCapacidade() {
		return this.contElementos < this.elementos.length;
	}

	// Método da prova
	public void insertElementAfter(T elementoProcurado, T elementoParaInserir) {
		if (contains(elementoProcurado)) {
			this.add(pos + 1, elementoParaInserir);
		}
	}

	public T get(int indice) {
		T elemento = null;
		if (indice >= 0 && indice < this.contElementos) {
			elemento = this.elementos[indice];
		}
		return elemento;
	}

	@Override
	public String toString() {
		if (this.contElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < this.contElementos - 1; i++) {
			builder.append(elementos[i] + ",");
		}
		builder.append(elementos[contElementos - 1]);
		builder.append("]");
		return builder.toString();
	}
}