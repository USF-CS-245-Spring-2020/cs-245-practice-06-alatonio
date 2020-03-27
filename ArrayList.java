/*
	ArrayList.java
	Author: Aileen L. Cai
	Data Structures & Algorithms - David Guy Brizan
	03/26/2020
	Practice Assignment 06
*/


public class ArrayList<T> implements List<T> {

	protected T[] a;
	protected int size = 0;
	
	public ArrayList()
	{
		a = (T[]) new Object[10]; //creating a template array of size 10 
	}

	private void doubleArray()
	{
		a = (T[]) new Object[a.length * 2];   //doubling the size of the array when function is called 
	}

	public void add (int position, T data)  //inserting data into the array at a specific position
	{
		++size;  //increasing size
		if (size == a.length) //is the size becomes the same as the length of the array, we double the array 
			doubleArray();
		for (int i = size - 1; i > position; i--)   
			a[i] = a[i-1]; //moving information to adjust for new addition
		a[position] = data;  //placing new information in desired location
	}

	public void add (T item) //adding new information to the array w/o specified position
	{
		if (a.length == size)  
			doubleArray();
		a[size++] = item;   //adding information at the end of the array
	}

	public T get(int position) throws Exception //retrieving an item from a specific position
	{
		if (position < 0 || position >= size)
			throw new Exception("Position value outside of array.");
		return a[position];  
	}

	public T remove(int position) throws Exception //removing an item in the array at a specific position
	{
		if (position < 0 || position >= size)
			throw new Exception("Position value outside of array.");

		T temp = a[position];
		for (int i = position; i < size; i++)
		{
			a[i] = a[i + 1];
			--size;
		}
		return temp; //returning what the removed value was 
	}

	public int size()
	{
		return size;   
	}
}