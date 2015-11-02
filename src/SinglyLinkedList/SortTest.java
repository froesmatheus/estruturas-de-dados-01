package SinglyLinkedList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class SortTest {
	

	ListaSimpEnc<Integer> lista = new ListaSimpEnc<Integer>();

	@Before
	public void setUp() throws Exception {
		lista.addFirst(3);
		lista.addFirst(5);
		lista.addFirst(1);
		lista.addFirst(2);
		lista.addFirst(20);
		lista.addFirst(4);
		lista.addFirst(6);
		lista.addFirst(10);
		lista.addFirst(12);
		lista.addFirst(7);
	}


	@Test
	public void QuickSortTest() {
	    lista.QuickSort(lista.getFirst(), lista.getLast());
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}
	
	@Test
	public void InsertionSortTest() {
	    lista.InsertionSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}
	
	@Test
	public void SelectionSortTest() {
	    lista.SelectionSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}
	
	@Test
	public void BubbleSortTest() {
	    lista.BubbleSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}

}
