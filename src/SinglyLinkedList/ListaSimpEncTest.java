package SinglyLinkedList;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaSimpEncTest {

	ListaSimpEnc<Integer> lista;
	
	@Before
	public void Iniciar() {
		lista = new ListaSimpEnc<Integer>();

	}

	@Test
	public void InserirNoInicioTest() {
		lista.addFirst(9);
		assertEquals("[9]", lista.toString());
	}

	@Test
	public void ContemTest() {
		lista.addFirst(9);
		lista.addFirst(6);
		lista.addFirst(2);
		lista.addFirst(1);

		assertEquals(true, lista.contains(2));
	}

	@Test
	public void NaoContemTest() {
		lista.addFirst(9);
		lista.addFirst(6);
		lista.addFirst(2);
		lista.addFirst(1);

		assertEquals(false, lista.contains(10));
	}

	@Test
	public void InserirVariosInicioTest() {
		lista.addFirst(9);
		lista.addFirst(6);
		lista.addFirst(2);
		lista.addFirst(1);

		assertEquals("[1,2,6,9]", lista.toString());
	}

	@Test
	public void InserirVariosFimTest() {
		lista.addFirst(6);
		lista.addFirst(2);
		lista.addFirst(1);
		lista.addLast(9);
		assertEquals("[1,2,6,9]", lista.toString());
	}

	@Test
	public void InserirDoisFimTest() {
		lista.addLast(9);
		lista.addLast(2);
		assertEquals("[9,2]", lista.toString());
	}

	@Test
	public void InserirTresFimTest() {
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(1);
		assertEquals("[9,2,1]", lista.toString());
	}

	@Test
	public void InserirPosTest() {
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(1);
		lista.add(1, (Integer) 6);
		assertEquals("[6,9,2,1]", lista.toString());
	}

	@Test
	public void InserirPosFimTest() {
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(1);
		lista.add(4, (Integer) 6);
		assertEquals("[9,2,1,6]", lista.toString());
	}

	@Test
	public void RemoverInicioTest() {
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(1);
		lista.removeFirst();
		assertEquals("[2,1]", lista.toString());
	}

	@Test
	public void RemoverUnicoTest() {
		lista.addLast(9);
		lista.removeFirst();
		assertEquals("[]", lista.toString());
	}

	@Test
	public void RemoverTresTest() {
		lista.addLast(2);
		lista.addLast(1);
		lista.addFirst(9);
		lista.removeFirst();
		assertEquals("[2,1]", lista.toString());
	}

	@Test
	public void RemoverFimTest() {
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(1);
		lista.removeLast();
		assertEquals("[9,2]", lista.toString());
	}

	@Test
	public void RemoverFimUnicoTest() {
		lista.addLast(9);
		lista.removeLast();
		assertEquals("[]", lista.toString());
	}


	@Test
	public void AdicionarTest() {
		lista.addLast(7);
		assertEquals("[7]", lista.toString());
	}
	
	@Test
	public void Adicionar2ElementosTest() {
		lista.addLast(7);
		lista.addLast(8);
		assertEquals("[7,8]", lista.toString());
	}
	

	
	
	@Test
	public void AdicionarPosicaoTest() {
		lista.add(1, 1);
		assertEquals("[1]", lista.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoNegativaTest() {
		lista.add(-1, 1);
	}
	

	public void RemoverInicioListaVaziaTest() {
		lista.removeFirst();
		assertEquals("[]", lista.toString());
	}
	

	public void RemoverFimListaVaziaTest() {
		lista.removeLast();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void SizeTest() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertEquals(3, lista.size());
	}
	
	@Test
	public void TamanhoVaziaTest() {
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
