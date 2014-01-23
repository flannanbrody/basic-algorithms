package linkedList;

import java.util.Iterator;
import java.util.HashSet;
import java.util.NoSuchElementException;
 
 
/*
 *  A LinkedList class with a private static inner node class
 * 	based on: 
 *  http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 *  
 *  CarrerCup 2.1  removeDup() removeDupWithoutBuffer()
 *  CarrerCup 2.2 findLastNth()
 *  
 */
public class LinkedList<AnyType> implements Iterable<AnyType> {
	
	public Node<AnyType> head;
	int size = 0;
	/*
	 * constructs an empty list
	 */
	public LinkedList(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null ;
	}
	/*
	 *  Insert a new node at the beginning of the list
	 */
	public void addFirst(AnyType data){
		head = new Node<AnyType>(data, head);
		size++;
	}
	
	public AnyType getFirst(){
		if(head == null)
			throw new NoSuchElementException();
		return head.data;
	}
	
	public AnyType removeFirst(){
		AnyType tmp = getFirst();
		head = head.next;
		size--;
		return tmp;
	}
	/*
	 * Insert a new node to the last of this list
	 */
	public void addLast(AnyType item){
		if(head == null)
			addFirst(item);
		else{
			Node<AnyType> tmp = head;
			while(tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node<AnyType>(item, null);
		}
		size++;
	}
	
	public AnyType getLast(){
		if(head == null)
			 throw new NoSuchElementException();
		else{
			Node<AnyType> tmp = head;
			while(tmp.next != null)
				tmp = tmp.next;
			return tmp.data;
		}
	}
	
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * insert a node after the node containing key
	 * if we found the node containing key, add a new node after it, return true
	 * if there is no node containing the key, return false
	 */
	public boolean insertAfter(AnyType key, AnyType toInsert){
		Node<AnyType> tmp = head;
		while(tmp != null && !tmp.data.equals(key))
			tmp = tmp.next;
		
		if(tmp != null){
			tmp.next = new Node<AnyType>(toInsert, tmp.next);
			size++;
			return true;
		}
		return false;
	}
	/*
	 * insert a node before the node containing the key
	 * return true if we insert it successfully
	 */
	public boolean insertBefore(AnyType key, AnyType toInsert){
		if(head == null)
			return false;
		
		if(head.data.equals(key)){
			addFirst(toInsert); // no need to size++, already done in addFirst();
			return true;
		}
		
		Node<AnyType> pre = null;
		Node<AnyType> current = head;
		
		while(current != null && !current.data.equals(key)){
			pre = current;
			current = current.next;
		}
		
		if(current != null){
			pre.next = new Node<AnyType>(toInsert, current);
			size++;
			return true;
		}
		return false;
	}
	/*
	 * 
	 */
	public void remove(AnyType key){
		if(head == null)
			throw new RuntimeException("cannot delete, the list is empty");
		
		if(head.data.equals(key)){
			head = head.next;
			size--;
			return;
		}
		
		Node<AnyType> pre = null;
		Node<AnyType> current = head;
		
		while(current != null && !current.data.equals(key)){
			pre = current;
			current = current.next;
		}
		// there is no node containing key
		if(current == null)
			throw new RuntimeException("cannot delete, there is no such element");
	
		pre.next = current.next;
		size--;
	}
	
	public boolean contains(AnyType item){
		for(AnyType t: this){
			if(t.equals(item))
				return true;
		}
		return false;
	}
	
	public AnyType get(int pos){
		if(head == null)
			throw new IndexOutOfBoundsException();
		Node<AnyType> tmp = head;
		
		for(int k = 0; k < pos ; k++)
			tmp = tmp.next;
		
		if(tmp == null)
			throw new IndexOutOfBoundsException();
		
		return tmp.data; 
	}
	
	public int size(){
		return size;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(AnyType x : this)
			sb.append(x+" ");
		return sb.toString();
	}
	/*
	 * reverse the list
	 */
	public LinkedList<AnyType> reverse(){
		LinkedList<AnyType> list = new LinkedList<AnyType>();
		Node<AnyType> tmp = head;
		while(tmp != null){
			list.addFirst(tmp.data);
			tmp = tmp.next;
		}
		return list;
	}
	/*
	 * return a deep copy of the list
	 * time complexity O(n^2)
	 */
	public LinkedList<AnyType> copy1(){
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		Node<AnyType> tmp = head;
		while(tmp != null){
			twin.addLast(tmp.data);
			tmp = tmp.next;
		}
		return twin;
	}
	
	public LinkedList<AnyType> copy2(){
		LinkedList<AnyType> list = new LinkedList<AnyType>();
		Node<AnyType> tmp = head;
		while(tmp != null){
			list.addFirst(tmp.data);
			tmp = tmp.next;
		}
		return list.reverse();
	}
	
	public LinkedList<AnyType> copy3(){
		if(head == null)
			return null;
		LinkedList<AnyType> twin = new LinkedList<AnyType>();
		Node<AnyType> tmp = head;
		twin.head = new Node<AnyType>(head.data, null);
		Node<AnyType> twinTmp = twin.head;
		
		while(tmp.next != null){
			tmp = tmp.next;
			twinTmp.next = new Node<AnyType>(tmp.data, null);
			twinTmp = twinTmp.next;
		}
		return twin;
	}
	/********************************************************************
	 * CarrerCup 2.1
	 * Remove duplicated elements in a linked list
	 * 
	 * use an extra HashSet
	 */
	
	public void removeDup(){
		if(head == null)
			return;
		Node<AnyType> current = head;
		Node<AnyType> pre = null;
		HashSet<AnyType> set = new HashSet<AnyType>();
		
		while(current != null){
			if(set.contains(current.data))
				pre.next = current.next;
			else{
				set.add(current.data);
				pre= current;
			}
			current = current.next;
		}
	}
	
	public void removeDupWithoutBuffer(){
		if(head == null)
			return;
		
		Node<AnyType> processed = head;
		Node<AnyType> current = head.next;
		Node<AnyType> runner;
		
		while(current != null){
			runner = head;
			while(runner != current){
				 if(runner.data.equals(current.data)){
					 //we need to remove current node
					 processed.next = current.next;
					 current = current.next;
					 break;
				 }
				 runner = runner.next;
			}
			if(runner == current){
				processed = current;
				current = current.next;
			}
		}
		
	}
	
	public AnyType findLastNth(int k){
		if(head == null || k <= 0)
			return null;
		if(size() < k)
			return null;
		
		Node<AnyType> tmp = head;
		for(int i = 0; i < k; i++)
			tmp = tmp.next;
		Node<AnyType> p = head;
		
		while(tmp != null){
			tmp = tmp.next;
			p = p.next;
		}
		
		return p.data;
	}
	
	/**********************************************************************
 
	/*
	 * the Node class
	 */
	public static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> next){
			this.data = data;
			this.next = next;
		}
	}
	
	public Iterator<AnyType> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<AnyType>{
		private Node<AnyType> nextNode;
		
		public LinkedListIterator(){
			nextNode = head;
		}
		
		public boolean hasNext(){
			return nextNode != null;
		}
		
		public AnyType next(){
			if(!hasNext())
				throw new NoSuchElementException();
			AnyType tmp = nextNode.data;
			nextNode = nextNode.next;
			return tmp;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
