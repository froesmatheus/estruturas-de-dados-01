package Queue;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FilaVetTest {
	
	FilaVet<Integer> fila = new FilaVet<Integer>();

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
		assertTrue(fila.contains(2));
	}
	
	@Test
	public void naoContemTest() {
		assertFalse(fila.contains(3));
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
