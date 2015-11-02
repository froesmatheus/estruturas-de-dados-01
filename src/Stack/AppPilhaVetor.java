package Stack;



public class AppPilhaVetor {
	public static void main(String[] args) {
		PilhaVet<Integer> pilha = new PilhaVet<>();
		
		pilha.push(10);
		pilha.push(9);
		pilha.push(8);
		pilha.push(7);
		pilha.push(6);
		pilha.push(5);
		pilha.push(4);
		pilha.push(3);
		pilha.push(2);
		pilha.push(1);
		
		System.out.println(pilha);
				
		pilha.Reverse();
		
		System.out.println(pilha);
	}
}
