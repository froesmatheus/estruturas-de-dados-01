package Stack;


public interface IPilha<T> {

		// Consulta o topo da pilha sem remov�-la e retorna o topo
		public T peek();

		// Limpa toda a pilha
		public void clear();

		// size de elementos que a pilha possui
		public int size();

		// Retorna se a pilha esta ou nao vazia
		public boolean isEmpty();

		// Indica se a pilha possui o elemento
		public boolean contains(T elemento);
		
		//retorna a distance de um objeto em rela�‹o ao topo
		//o vizinho mais proximo possui distance 1 do topo
		public int distance(T elemento);

		// Remove o topo da pilha e retorna o objeto removido
		public T pop();

		// Adiciona um elemento no topo da pilha
		public void push(T elemento);
		
		public String toString();
	}



