package Stack;

@SuppressWarnings("unchecked")
public class PilhaVet<T> implements IPilha<T>{
	private T elementos[];
	private int contElementos, pos;
	
	public PilhaVet() {
		elementos = (T[]) new Object[10];
	}
	
	public PilhaVet(int tamanhoInicial) {
		elementos = (T[]) new Object[tamanhoInicial];
	}
	
	@Override
	public T peek() {
		if (this.contElementos > 0) {
			return this.elementos[this.contElementos-1];
		}
		return null;
	}

	@Override
	public void clear() {
		if (this.contElementos > 0) {
			for (int i = 0; i < this.contElementos; i++) {
				this.elementos[i] = null;
			}
		}
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
		for (int i = 0; i < contElementos; i++) {
			if (this.elementos[i].equals(elemento)) {
				this.pos = i;
				return true;
			}
		}
		return false;
	}

	@Override
	public int distance(T elemento) {
		int contador = -1;
		if (this.contains(elemento)) {
			for (int i = this.pos; i < this.contElementos; i++) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public T pop() {
		if (this.contElementos > 0) {
			T elemento = elementos[this.contElementos-1];
			elementos[this.contElementos-1] = null;
			this.contElementos--;
			return elemento;
		}
		return null;
	}
	
	@Override
	public void push(T elemento) {
		this.verificarCapacidade();
		
		this.elementos[contElementos] = elemento;
		this.contElementos++;
	}
	
	private void verificarCapacidade() {
		if (this.contElementos == this.elementos.length) {
			this.redimensionarVetor();
		}
	}
	
	public void Reverse() {
		this.Reverse(0, this.contElementos-1);
	}
	
	public void Reverse(int ini, int fim) {
		if (ini < fim) {
			inverterElemento(ini, fim);
			Reverse(ini+1, fim-1);
		}
	}
	
	public void inverterElemento(int index, int index2) {
		T aux = this.elementos[index];
		this.elementos[index] = this.elementos[index2];
		this.elementos[index2] = aux;
	}
	
	private void redimensionarVetor() {
		T[] lista = (T[]) new Object[elementos.length * 2];
		System.arraycopy(elementos, 0, lista, 0, contElementos);
		elementos = lista;
	}
	
	public void empilharComeco(T elemento) {
		for (int i = contElementos - 1; i >= 0; i--) {
			elementos[i + 1] = elementos[i];
		}
		elementos[0] = elemento;
		contElementos++;
	}
	
	@Override
	public String toString() {
		if (this.contElementos == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < this.contElementos-1; i++) {
			builder.append(this.elementos[i] + ",");
		}
		builder.append(this.elementos[this.contElementos-1]);
		builder.append("]");
		return builder.toString();
	}
}
