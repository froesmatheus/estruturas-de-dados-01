package Hashtable;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class TabelaHashTest {

	HashEnc<Integer> hashEnc;

	@Before
	public void setUp() throws Exception {
		hashEnc = new HashEnc<Integer>();
	}
	
	@Test
	public void inserirTest() {
		hashEnc.add(13);

		assertEquals(1, hashEnc.size());
	}
	
	@Test
	public void inserirDoisElementosTest() {
		hashEnc.add(13);
		hashEnc.add(25);
		assertEquals(2, hashEnc.size());
	}
	
	@Test
	public void inserirMesmoElementoTest() {
		hashEnc.add(13);
		hashEnc.add(13);
		assertEquals(2, hashEnc.size());
	}
	
	@Test
	public void removerTest(){
		hashEnc.add(13);
		hashEnc.remove(13);
		assertEquals(0, hashEnc.size());
	}

	@Test
	public void contemTest(){
		hashEnc.add(13);
		boolean resultado = hashEnc.contains((Integer) 13);
		assertEquals(true, resultado);
		
	}

	@Test
	public void naoContemTest(){
		hashEnc.add(13);
		boolean resultado = hashEnc.contains((Integer) 15);
		assertEquals(false, resultado);
		
	}

	// coloca todos os elementos em uma �nica lista encadeada
	@Test
	public void todosElementosTest(){
		hashEnc.add(1);
		hashEnc.add(2);
		hashEnc.add(3);
		hashEnc.add(4);
		hashEnc.add(5);

		
		assertEquals(5, hashEnc.asList().size());
		
	}
	
	@Test
	public void verificarCargaTest(){
		
		hashEnc.add(1);
		hashEnc.add(2);
		hashEnc.add(3);
		hashEnc.add(4);
		hashEnc.add(5);
		hashEnc.add(6);
		hashEnc.add(7);
		hashEnc.add(8);
		hashEnc.add(9);
		hashEnc.add(10);
		
		assertEquals(22, hashEnc.size());
		
	}

	

}
