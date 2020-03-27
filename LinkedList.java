/*
	LinkedList.java
	Author: Aileen L. Cai
	Data Structures & Algorithms - David Guy Brizan
	03/26/2020
	Practice Assignment 06
*/


class Node<T> 
{
	T data;
	Node next;

	public Node(T data)  //constructor
	{
		this.data = data;
		this.next = null;
	}
}

public class LinkedList<T> implements List<T>
{
	private Node<T> head;
	private int size;

	public LinkedList() //LinkedList constructor; initializing values
	{
		size = 0;
		head = null;
	}

	public void add(T data)
	{
		if (head == null)   //if nothing is in LinkedList yet 
		{
			Node<T> current = new Node<T>(data);
			head = current;
			++size;	
		}

		else 
		{
			Node<T> previous = head;   //previous becomes the head of the Linked List
			 
			for (int i = 0; i < size; i++)
				previous = previous.next; //everything gets moved down 1 position
			
			Node<T> current = new Node<T>(data);  //inserting new data
			previous.next = current;
			++size; //increasing size
		}
	}

	public void add(int position, T data)
	{
		if (position == 0)  //if nothing exists in the LinkedListt yett 
		{
			Node<T> current = new Node<T>(data);
			current.next = head;  //preexisiting data in head moves down 1 position
			head = current; //new data becomes head
			++size; //increase size of LinkedList
		}

		else
		{
			Node<T> previous = head; 

			for (int i = 0; i < position; i++) //up until desired position, data moves over to next position
				previous = previous.next;

			Node<T> current = new Node<T>(data); //new node for new data
			current.next = head; 
			previous.next = current;
			++size;
		}
	}

	public T get(int position) throws Exception //retrieving a value at a particular position
	{
		if (position < 0 || position >= size)  //if position value doesn't exist
			throw new Exception("Position value out of bounds."); 
		
		Node<T> node = head; //starting at the beginning of the LinkedList

		for (int i = 0; i < position; i++)  //changing node until it reaches desired position
			node = node.next;

		return node.data; //returning data of the node

	}

	public T remove(int position) throws Exception
	{
		if (position < 0 || position >= size)
			throw new Exception("Position value out of bounds.");

		if (position == 0) 
		{
			Node<T> current = head; 
			head = head.next;
			--size;
			return current.data;
		}

		else 
		{
			Node<T> previous = head;
			
			for (int i = 0; i < position; i++)
				previous = previous.next; 
			
			Node<T> current = previous.next; //need to change what the previous's next is
			previous.next = current.next; //
			--size; //decrease size of LinkedList
			return current.data; //return removed data
		}
	}

	public int size()
	{
		return size;
	}
}