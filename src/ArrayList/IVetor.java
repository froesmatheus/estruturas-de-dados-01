package ArrayList;
import java.util.Iterator;

public interface IVetor<T> {
	
	public void add(T elemento);
	
	public void add(int posicao, T elemento) throws IndexOutOfBoundsException;
	
	public void addFirst(T elemento);
	
	public void remove(int posicao);
	
	public void remove(T elemento);
	
	public void removeFirst();
	
	public void removeLast();
	
	public int size();
	
	public void clear();
	
	public boolean contains(T elemento);
	
	public String toString();
	
	public Iterator<T> iterator();
}
