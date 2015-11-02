package ArrayList;

public class App {
	public static void main(String[] args) {
		ListaVetor<Integer> lista = new ListaVetor<Integer>();



		lista.add(8);
		lista.add(3);
		lista.add(1);
		lista.add(6);
		lista.add(5);
		lista.add(9);
		
		System.out.println(lista);
		lista.quickSort();
		System.out.println(lista);
	}
}
