package Queue;

@SuppressWarnings("unchecked")
public class FilaVet<T> implements IFila<T>{
	private int contElementos;
	private T[] elementos;
	private int pos;
	
	public FilaVet() {
		elementos = (T[]) new Object[10];
	}
	
	@Override
	public void clear() {
		if (this.contElementos > 0) {
			for (int i = 0; i < this.contElementos; i++) {
				this.elementos[i] = null;
			}
			this.contElementos = 0;
		}
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
			if (elementos[i].equals(elemento)) {
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
			for (int i = pos; i >= 0; i--) {
				contador++;
			}
		}
		return contador;
	}

	@Override
	public T remove() {
		T elemento = null;
		if (!isEmpty()) {
			elemento = elementos[0];
			elementos[0] = null;
			for (int i = 0; i < contElementos-1; i++) {
				elementos[i] = elementos[i+1];
			}
			contElementos--;
		}
		return elemento;
	}

	private void redimensionarVetor() {
		T[] lista = (T[]) new Object[elementos.length * 2];
		System.arraycopy(elementos, 0, lista, 0, contElementos);
		elementos = lista;
	}
	
	private boolean verificarCapacidade() {
		if (this.contElementos == this.elementos.length) {
			this.redimensionarVetor();
			return true;
		}
		return false;
	}
	
	@Override
	public void enqueue(T elemento) {
		this.verificarCapacidade();
		
		this.elementos[contElementos] = elemento;
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
