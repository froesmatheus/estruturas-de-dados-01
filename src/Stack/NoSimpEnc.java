package Stack;

public class NoSimpEnc<T> {

	private T elemento;
	private NoSimpEnc<T> proximo;

	public NoSimpEnc(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}

	public NoSimpEnc(T elemento, NoSimpEnc<T> proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}

	public void setProximo(NoSimpEnc<T> proximo) {
		this.proximo = proximo;
	}

	public NoSimpEnc<T> getProximo() {
		return proximo;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
}
