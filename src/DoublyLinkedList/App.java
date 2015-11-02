package DoublyLinkedList;



public class App {
	public static void main(String[] args) {
		ListaDupEnc<Integer> lista = new ListaDupEnc<>();



		lista.addLast(4);
		lista.addLast(-4);
		
		lista.bubbleSort();
		
		System.out.println(lista);
		
	}
}
