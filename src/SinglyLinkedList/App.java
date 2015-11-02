package SinglyLinkedList;





public class App {
	public static void main(String[] args) {		
		ListaSimpEnc<Integer> lista = new ListaSimpEnc<Integer>();

		lista.addLast(1);
		lista.addLast(3);
		lista.addLast(5);
		lista.addLast(7);
		lista.addLast(9);
		
		System.out.println("Lista 1: " + lista);	
		
		
		ListaSimpEnc<Integer> lista2 = new ListaSimpEnc<Integer>();
		
		lista2.addLast(2);
		lista2.addLast(4);
		lista2.addLast(6);
		lista2.addLast(8);
		lista2.addLast(10);
		
		System.out.println("Lista 2: " + lista2);
		
		ListaSimpEnc<Integer> list = lista.concatenarOrdenado(lista2);
		
		System.out.println("Lista concat e ord: " + list);
	
		System.out.println("Lista 1: " + lista);
		System.out.println("Lista 2: " + lista2);
	}
}
