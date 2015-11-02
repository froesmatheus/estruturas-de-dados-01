package Queue;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class FilaEncTest {
	
	FilaEnc<Integer> fila = new FilaEnc<Integer>();

	@Before
	public void setUp() throws Exception {
		
		fila.enqueue(2);
	}


	@Test
	public void limparTest() {
		fila.clear();
		assertTrue(fila.isEmpty());
	}

	@Test
	public void tamanhoTest() {
		assertEquals(1, fila.size());
	}
	
	@Test
	public void estaVaziaTest() {
		assertFalse(fila.isEmpty());
	}

	@Test
	public void contemTest() {
		assertEquals(true,fila.contains(2));
	}
	
	@Test
	public void naoContemTest() {
		assertEquals(false,fila.contains(3));
	}
	
	@Test
	public void distanciaTest() {
		assertEquals(0, fila.distance(2));
		
	}

	@Test
	public void removerTest() {
		fila.enqueue(3);
		fila.enqueue(1);
		fila.remove();
		assertEquals("[3,1]",fila.toString());
		
	}
	
	@Test
	public void enfileirarTest() {
		fila.enqueue(4);
		fila.enqueue(5);
		assertEquals("[2,4,5]", fila.toString());
	}
}
