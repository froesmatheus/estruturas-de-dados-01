package Stack;

import java.util.Stack;

public class AppPilhaEnc {

	public static void main(String[] args) {
		PilhaEnc<Integer> pilhaEnc = new PilhaEnc<Integer>();
		
		
		pilhaEnc.push(100);
		pilhaEnc.push(30);
		pilhaEnc.push(100);
		pilhaEnc.push(30);
		pilhaEnc.push(100);
		pilhaEnc.push(30);
		pilhaEnc.push(100);
		pilhaEnc.push(30);
		pilhaEnc.push(100);
		pilhaEnc.push(50);

		System.out.println(pilhaEnc);
		
		Stack<Integer> pilha = new Stack<Integer>();
		
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.push(5);
		pilha.push(6);
		
		
	}

}
