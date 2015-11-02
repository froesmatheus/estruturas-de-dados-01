package Hashtable;



public class App {

	public static void main(String[] args) {
		HashEnc<Integer> hashTable = new HashEnc<Integer>();
			
		hashTable.add(1);
		hashTable.add(1);
		hashTable.add(1);
		hashTable.add(2);
		hashTable.add(3);
		hashTable.add(4);
		hashTable.add(5);
		hashTable.add(30);
		hashTable.add(32);
		hashTable.add(32);
		
		System.out.println(hashTable);
	}
}
