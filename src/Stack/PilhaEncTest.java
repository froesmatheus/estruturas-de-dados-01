package Stack;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class PilhaEncTest {

	@SuppressWarnings("rawtypes")
	PilhaEnc pilha = new PilhaEnc();

	
	@Before
	public void setUp() throws Exception {
		
		pilha.push(1);
	}

	@Test
	public void topTest() {
		assertEquals(1, pilha.peek());
	}
	
	@Test
	public void limparTest() {
		pilha.clear();
		assertTrue(pilha.isEmpty());
	}

	@Test
	public void tamanhoTest() {
		assertEquals(1, pilha.size());
	}
	
	@Test
	public void estaVaziaTest() {
		assertFalse(pilha.isEmpty());
	}

	@Test
	public void contemTest() {
		assertTrue(pilha.contains(1));
	}
	
	@Test
	public void naoContemTest() {
		assertFalse(pilha.contains(3));
	}
	
	@Test
	public void distanciaTest() {
		assertEquals(0, pilha.distance(1));
		
	}

	@Test
	public void desempilharTest() {
		pilha.push(2);
		pilha.push(3);
		pilha.pop();
		assertEquals("[2,1]",pilha.toString());
		
	}
	
	@Test
	public void empilharTest() {
		pilha.push(2);
		pilha.push(3);
		assertEquals("[3,2,1]", pilha.toString());
	}



}
