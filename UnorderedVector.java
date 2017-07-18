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
        currentSize++;
    }
    
//  Adds the Object obj to the end of the list.
    public void addLast(E obj) { 
        storage[currentSize+1] = obj;
        currentSize++;
    }
    
//  Adds the Object obj to the list in the position indicated.  The list is one based, and
//  the first element is at position #1 (not zero).  If the position is currently occupied
//  existing elements must be shifted over to make room for the insertion.     
    public void add(E obj, int position) { 
        position--;
        
        if(isFull())
            resize(storage);
        if(!isValidPosition(position))
            throw new RuntimeException("invalid location");
        else {
            if(storage[position]!=null){
                    shiftRight(position);
                    storage[position]=obj;
                    currentSize++;
            }
            else{
                storage[position]=obj;
                currentSize++;
            }
        }   
    }        
        private void shiftRight(int position){
         position--;
         for(int i= (position); i<(currentSize); i++){
           storage[i+1]=storage[i];
            }
        }
       
    
    private boolean isValidPosition(int pos){
        return !(pos<0||pos>currentSize);
    }
    
    private void resize(E[] storage){
        maxSize *= 2;
        E[] newObject = (E[]) new Object[maxSize];

        for(int i = 0; i < currentSize; i++) 
            newObject[i] = storage[i];
        storage = newObject;
    }
    
//  Removes and returns the object located at the parameter position.
//  Throws a RuntimeException if the position does not map to a valid position within the list.
    public E remove(int position) { 
        position--; 
        E tmp=null;
        if(!isValidPosition(position))
            throw new RuntimeException("invalid location");
        else {
            tmp=storage[position];
            shiftLeft(position);
            currentSize--;
        }
        return tmp;
    }
       private void shiftLeft(int position){
       position-- ;
       for(int i=position; i<currentSize; i++){
           storage[i]=storage[i+1];
            }
       }
     
//  Removes and returns the parameter object obj from the list if the list contains it, 
//  null otherwise.  If more than one element matches, the element is lowest position is removed
//  and returned.
    public E remove(E obj) { 
        E tmp = null;
        boolean ExcuteOnce=false;
        if(contains(obj)){
            if(! ExcuteOnce) {
                obj=tmp;
                shiftLeft(find(obj)); 
                ExcuteOnce=true;
            } 
        }
        return tmp;  
    } 
    
//  Removes and returns the first element in the list and null if the it is empty.
    public E removeFirst() { 
        if(storage[0]!= null)
            return storage[0];
            remove() storage[0];
        else 
            return null;
            
            else {
    		head = head.next;
    		currentSize--;
    		return current.data;
    }
    
//  Removes and returns the last element in the list and null if the it is empty.
    
    public E removeLast() { 
        E tmp=null;
        
        if(storage[1]==null){
            tmp = storage[0];
            storage[0]=null;
        }
        if(storage[currentSize-1]!=null){
            tmp=storage[currentSize-1];
            shiftLeft(currentSize);
            currentSize--;
        }
        return tmp;
    }      

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



