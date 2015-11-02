package Queue;


public interface IFila<T> {


		// Limpa toda a fila
		public void clear();

		// size de elementos que a pilha possui
		public int size();

		// Retorna se a fila esta ou nao vazia
		public boolean isEmpty();

		// Indica se a fila possui o elemento
		public boolean contains(T elemento);
		
		//retorna a distance de um objeto em rela�‹o ao in’cio da fila
		//o vizinho mais proximo possui distance 1 do in’cio
		public int distance(T elemento);

		// Remove o primeira da fila 
		public T remove();

		// Adiciona um elemento no final da fila
		public void enqueue(T elemento);
		
		public String toString();
	}



