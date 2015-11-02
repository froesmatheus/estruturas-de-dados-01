package ArrayList;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClasseListaVetorTest {
	
	private static ListaVetor<Integer> lista;
	
	@Before
	public void Iniciar()
	{
		lista = new ListaVetor<Integer>();
	}
	
	@Test
	public void AdicionarTest() {
		lista.add(7);
		assertEquals("[7]", lista.toString());
	}
	
	@Test
	public void Adicionar2ElementosTest() {
		lista.add(7);
		lista.add(8);
		assertEquals("[7,8]", lista.toString());
	}
	
	@Test
	public void AdicionarRedimensionandoTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		lista.add(7);
		lista.add(8);
		lista.add(9);
		lista.add(10);
		lista.add(11);
		lista.add(12);
		assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12]", lista.toString());
	}
	
	
	@Test
	public void AdicionarPosicaoTest() {
		lista.add(0, 1);
		assertEquals("[1]", lista.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoNegativaTest() {
		lista.add(-1, 1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoExtraTest() {
		lista.add(20, 1);
	}

	
	@Test
	public void AdicionarInicioTest() {
		lista.addFirst(3);
		lista.addFirst(2);
		lista.addFirst(1);
		assertEquals("[1,2,3]", lista.toString());
	}
	
	@Test
	public void AdicionarInicioRedimensionandoTest() {
		lista.addFirst(12);
		lista.addFirst(11);
		lista.addFirst(10);
		lista.addFirst(9);
		lista.addFirst(8);
		lista.addFirst(7);
		lista.addFirst(6);
		lista.addFirst(5);
		lista.addFirst(4);
		lista.addFirst(3);
		lista.addFirst(2);
		lista.addFirst(1);
		assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12]", lista.toString());
	}
	
	@Test
	public void RemoverPosTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.remove(0);
		assertEquals("[2,3]", lista.toString());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverPosInexitenteTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.remove(-1);
	}
	
	@Test
	public void RemoverElementoTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.remove(2);
		assertEquals("[1,3]", lista.toString());
	}
	
	@Test
	public void RemoverElementoInexistenteTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.remove(4);
		assertEquals("[1,2,3]", lista.toString());
	}
	
	@Test
	public void RemoverInicioTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.removeFirst();
		assertEquals("[2,3]", lista.toString());
	}
	
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverInicioListaVaziaTest() {
		lista.removeFirst();
	}
	
	@Test
	public void RemoverFimTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.removeLast();
		assertEquals("[1,2]", lista.toString());
	}
	
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverFimListaVaziaTest() {
		lista.removeLast();
	}
	
	@Test
	public void TamanhoTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		assertEquals(3, lista.size());
	}
	
	@Test
	public void TamanhoVaziaTest() {
		assertEquals(0, lista.size());
	}
	
	
	@Test
	public void LimparTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void LimparListaVaziaTest() {
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ContemTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		assertEquals(true, lista.contains(2));
	}
	
	@Test
	public void ContemFalseTest() {
		lista.add(1);
		lista.add(2);
		lista.add(3);
		assertEquals(false, lista.contains(5));
	}
	
}
