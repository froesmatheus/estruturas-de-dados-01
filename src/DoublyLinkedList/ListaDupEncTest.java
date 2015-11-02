package DoublyLinkedList;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ListaDupEncTest {

	private ListaDupEnc<Integer> lista;
	
	@Before
	public void Iniciar(){
	
		lista = new ListaDupEnc<Integer>();
		lista.addFirst(8);
	}
	
	@Test
	public void ListaComElemento() {
		
		assertEquals("[8]", lista.toString());
	}
	
	@Test
	public void ListaComDois() {
		lista.addFirst(9);
		assertEquals("[9,8]", lista.toString());
	}
	
	@Test
	public void ListaComTres() {
		lista.addFirst(9);
		lista.addFirst(2);
		assertEquals("[2,9,8]", lista.toString());
	}
	
	@Test
	public void ListaFimComDois() {
		lista.addLast(2);
		assertEquals("[8,2]", lista.toString());
	}
	
	@Test
	public void ListaFimComTres() {
		lista.addLast(2);
		lista.addLast(9);
		assertEquals("[8,2,9]", lista.toString());
	}
	@Test
	public void ListaPos() {
		lista.add(1, 2);
		assertEquals("[2,8]", lista.toString());
	}
	
	@Test
	public void ListaPosDois() {
		lista.addLast(2);
		lista.addLast(9);
		lista.add(2, 6);
		assertEquals("[8,6,2,9]", lista.toString());
	}
	
	@Test
	public void ListaPosFim() {
		lista.addLast(2);
		lista.addLast(9);
		lista.add(4, 6);
		assertEquals("[8,2,9,6]", lista.toString());
	}
	
	@Test
	public void ListaContem() {
		assertEquals(true, lista.contains(8));
	}
	
	@Test
	public void ListaContemUltimo() {
		lista.addLast(2);
		lista.addLast(9);
		assertEquals(true, lista.contains(9));
	}
	
	@Test
	public void ListaContemMeio() {
		lista.addLast(2);
		lista.addLast(9);
		assertEquals(true, lista.contains(2));
	}
	@Test
	public void ListaNaoContem() {
		lista.addLast(2);
		lista.addLast(9);
		assertEquals(false, lista.contains(19));
	}
	
	@Test
	public void ListaRemoverInicio() {
		lista.removeFirst();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ListaRemoverUm() {
		lista.addLast(2);
		lista.removeFirst();
		assertEquals("[2]", lista.toString());
	}
	
	@Test
	public void ListaRemoverDois() {
		lista.addLast(2);
		lista.addLast(9);
		lista.removeFirst();
		assertEquals("[2,9]", lista.toString());
	}
	
	@Test
	public void ListaRemoverTres() {
		lista.addLast(2);
		lista.addLast(7);
		lista.addFirst(9);
		lista.removeFirst();
		assertEquals("[8,2,7]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFim() {
		lista.removeLast();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimDois() {
		lista.addLast(2);
		lista.removeLast();
		assertEquals("[8]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimTres() {
		lista.addLast(2);
		lista.addLast(7);
		lista.addFirst(9);
		lista.removeLast();
		assertEquals("[9,8,2]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimVarios() {
		lista.addFirst(2);
		lista.removeLast();
		assertEquals("[2]", lista.toString());
	}
	
	@Test
	public void TestInterator() {
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		assertEquals(8, valor);
	}

	@Test
	public void TestTerceiroInterator() {
		lista.addLast(2);
		lista.addLast(4);
		lista.addLast(6);
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		valor = i.next();
		valor = i.next();
		assertEquals(4, valor);
	}
	
	@Test
	public void TestUltimoInterator() {
		lista.addLast(2);
		lista.addLast(4);
		lista.addLast(6);
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		valor = i.next();
		valor = i.next();
		valor = i.next();
		assertEquals(6, valor);
	}
	
	@Test
	public void SizeTest() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.removeFirst();
		assertEquals(3, lista.size());
	}
	
	@Test
	public void TamanhoVaziaTest() {
		lista.removeFirst();
		assertEquals(0, lista.size());
	}
	
	
	@Test
	public void LimparTest() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void LimparListaVaziaTest() {
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	
	
	@Test
	public void ContemFalseTest() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertEquals(false, lista.contains(5));
	}
	
	@Test
	public void getInicioTest(){
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.removeFirst();
		assertEquals((Integer) 1, lista.getFirst().getElemento());
	}
	
	@Test
	public void getFimTest(){
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertEquals((Integer) 3, lista.getLast().getElemento());
	}
	
	
	@Test
	public void estaVaziaTest(){
		lista.removeLast();
		assertEquals(true, lista.isEmpty());
	}
	
	@Test
	public void naoEstaVaziaTest(){
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertEquals(false, lista.isEmpty());
	}
	

}
