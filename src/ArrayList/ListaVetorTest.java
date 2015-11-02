package ArrayList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ListaVetorTest {
	ListaVetor<Integer> listaVetor;
	
	@Before
	public void setUp() throws Exception {
		listaVetor = new ListaVetor<Integer>();
		listaVetor.add(1);
		listaVetor.add(2);
		listaVetor.add(3);
		listaVetor.add(4);
		listaVetor.add(5);
	}

	@Test
	public void adicionarTest() {
		listaVetor.add(1);
		assertTrue(listaVetor.size() == 6);
	}
	
	@Test
	public void adicionarPosicaoTest() {
		listaVetor.add(0, 2);
		assertTrue(listaVetor.size() == 6);
		assertTrue(listaVetor.contains(1));
	}
	
	@Test
	public void adicionarNoFimTest() {
		listaVetor.add(1);
		listaVetor.add(2);
		listaVetor.add(3);
	}
	
	@Test
	public void removerPosicaoTest() {
		listaVetor.remove(0);
		assertTrue(listaVetor.size() == 4);
		listaVetor.remove(listaVetor.size() - 1);
		assertTrue(listaVetor.size() == 3);
	}
	
	@Test
	public void removerInicioTest() {
		listaVetor.removeFirst();
		assertTrue(listaVetor.size() == 4);
		assertTrue(!listaVetor.contains(1));
	}
	
	@Test
	public void removerFimTest() {
		listaVetor.removeLast();
		assertTrue(listaVetor.size() == 4);
		assertTrue(!listaVetor.contains(5));
	}
	
	@Test
	public void tamanhoAmostra() {
		assertEquals(5, listaVetor.size(), 0);
		while (listaVetor.iterator().hasNext()) {
			assertNotNull(listaVetor.iterator().next());
		}
	}
	
	@Test
	public void testesVariados() {
		listaVetor = new ListaVetor<Integer>(5);
		listaVetor.add(1);
		listaVetor.add(2);
		listaVetor.add(3);
		listaVetor.add(4);
		listaVetor.add(5);
		assertEquals(5, listaVetor.size(), 0);
		listaVetor.add(4, 56);
		assertEquals(6, listaVetor.size(), 0);
		listaVetor.remove(0);
		assertEquals(5, listaVetor.size());
	}
}
