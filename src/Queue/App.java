package Queue;


public class App {
	public static void main(String[] args) {
		FilaEnc<Integer> fila = new FilaEnc<Integer>();
		
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		fila.enqueue(6);
		fila.enqueue(7);
		
		System.out.println(fila);
		
		
	}
}
