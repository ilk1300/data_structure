/*
  William Liu
  cssc0126
    
    The list is one-based--the first element is at position #1 and the last element is
    at position currentSize.  Although the vector is not in sorted order, the ordering
    does matter. Order must be preserved if insertion/deletion happens in other than the last 
    position.  All of th elements in the list must be contiguous. 

For this assignment, you will write an UnorderedVector class. You will use an array as the underlying 
structure for your class. You will implement the UnorderedListADT interface given below.

*/

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnorderedVector<E> implements UnorderedListADT<E> {
    private final int DEFAULT_INIT_SIZE = 1000;
    private E[] storage;
    private int currentSize, maxSize;
    
    public UnorderedVector() {
   	currentSize = 0;
	maxSize = DEFAULT_INIT_SIZE;
    	storage = (E[]) new Object[maxSize];
	}

//  Adds the Object obj to the list in first position.
    public void addFirst(E obj) {
        
        storage[0] = obj;
    }
    
//  Adds the Object obj to the end of the list.
    public void addLast(E obj) { 
        storage[maxSize-1] = obj;
    }
    
//  Adds the Object obj to the list in the position indicated.  The list is one based, and
//  the first element is at position #1 (not zero).  If the position is currently occupied
//  existing elements must be shifted over to make room for the insertion.     
    public void add(E obj, int position) { 
        position--;
        
        
    }        

//  Removes and returns the object located at the parameter position.
//  Throws a RuntimeException if the position does not map to a valid position within the list.
    public E remove(int position) { 
         
    	Node <E> prev = null, current = head;
    	for (int i=1; i < position; i++){
    		now = current;
    	    current = current.next;
    	}
        
    		if (current == null) return null;
    		if (current == head) {					// if the obj is first
    			head = head.next;
    			currentSize --;
    			return null;
    		} else {								// base condition
    			prev.next = current.next;
   				currentSize --;
   				return null;
    			}
    	

        return null; }
    
//  Removes and returns the parameter object obj from the list if the list contains it, 
//  null otherwise.  If more than one element matches, the element is lowest position is removed
//  and returned.
    public E remove(E obj) { return null; } 
    
//  Removes and returns the first element in the list and null if the it is empty.
    public E removeFirst() { return null; }
    
//  Removes and returns the last element in the list and null if the it is empty.
    public E removeLast() { return null; }      

//  Returns the object located at the parameter position.
//  Throws a RuntimeException if the position does not map to a valid position within 
//  the list.
    public E get(int position) { return null; }
    
//  Returns the list object that matches the parameter, and null if the list is empty
//  or if the element is not in the list.  If obj matches more than one element, 
//  the element with the lowest position is returned.
    public E get(E obj) {     
        if (isEmpty()||storage[currentSize]!= obj)
            return null;
        else 
            return storage[currentSize]; 
    }
    
//  Returns the position of the first element that matches the parameter obj
//  and -1 if the item is not in the list.
    public int find(E obj) { 
        for(int i=0; i < currentSize; i++)
            if(((Comparable<E>)obj).compareTo(storage[i]) == 0)
            //if (storage[currentSize] == obj)
                return currentSize;
        return -1; 
    }  

//  Returns true if the parameter object obj is in the list, false otherwise.
    public boolean contains(E obj) {
        for(int i=0; i < currentSize; i++)
	    if(((Comparable<E>)obj).compareTo(storage[i]) == 0)
	        return true;
	return false;
	}   

//  The list is returned to an empty state.
    public void clear() { 
        for (int i=0;i<currentSize;i++)
            storage[i] = null;   
    }

//  Returns true if the list is empty, otherwise false
    public boolean isEmpty() {return size() == 0;}
    
//  Returns true if the list is full, otherwise false.  
    public boolean isFull() {return size() == maxSize;}

//  Returns the number of Objects currently in the list.
    public int size() { return currentSize; }
    
//  Returns an Iterator of the values in the list, presented in
//  the same order as the list.
    public Iterator<E> iterator() { 
        return new IteratorHelper();
	}
    /*pricate long modcounter---being tracked 
    
    if (modCounter !- modification"...)
    
    return storage[index++]
    */
	class IteratorHelper implements Iterator<E> {
        private int index;
	
	public IteratorHelper() {
	    index = 0;
	    }
	    
	public boolean hasNext() {
	    return index < currentSize;
	    }
	    
	public E next() {
	    if(!hasNext()) throw new NoSuchElementException();
	    return storage[index++];
	    }
	    
	public void remove() {
	    throw new UnsupportedOperationException();
	    }
	}

}



