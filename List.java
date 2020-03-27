
public interface List<T> {
	
	public void add(T item);
	public void add(int pos, T item);
	public T get(int pos) throws Exception;
	public T remove(int pos) throws Exception;
	public int size();

}
