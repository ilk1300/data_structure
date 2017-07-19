/*
  William Liu
  cssc0126
  cs310

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
    
    private boolean isValidPosition(int pos){
        return !(pos<0 || pos>=currentSize);
    }
    
    private void shiftLeft(int index){
       for(int i=index; i<currentSize; i++){
           storage[i]=storage[i+1];
            }
       }
    
    private void shiftRight(int index){
         for(int i=index; i>0; i--){ 
           storage[i]=storage[i-1];
         }  
    }
    
    private void resize(){
        maxSize *= 2;
        E[] newObject = (E[]) new Object[maxSize];
        for(int i = 0; i < currentSize; i++) 
            newObject[i] = storage[i];
        storage = newObject;
        
    }
    
    public UnorderedVector() {
   	currentSize = 0;
	maxSize = DEFAULT_INIT_SIZE;
    	storage = (E[]) new Object[maxSize];
	}
    
//  Adds the Object obj to the list in first position.
    public void addFirst(E obj) {
            if(currentSize==maxSize){
            resize();
        }
            currentSize++;      //original 
            shiftRight(currentSize-1); 
            storage[0]=obj;
           
    }
    
//  Adds the Object obj to the end of the list.
    public void addLast(E obj) { 
        
        if(currentSize==maxSize){
            resize();
        }
        storage[currentSize] = obj;
        currentSize++;
    }
    
//  Adds the Object obj to the list in the position indicated.  The list is one based, and
//  the first element is at position #1 (not zero).  If the position is currently occupied
//  existing elements must be shifted over to make room for the insertion.     
    public void add(E obj, int position) {              //works.
        position--;
      
        if(isFull())
            resize();
        if(!isValidPosition(position))
            throw new RuntimeException("invalid location");   
        if (position==(currentSize-1))
            addLast(obj);
        else{
            currentSize++;
            moveRight(position);
            storage[position]=obj;
            }
    }
    private void moveRight(int index){
         for(int i=(currentSize); i>index; i--){ 
           storage[i]=storage[i-1];
         }
    }        
    
//  Removes and returns the object located at the parameter position.
//  Throws a RuntimeException if the position does not map to a valid position within the list.
    public E remove(int position) {                     //works.
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
       
    
//  Removes and returns the parameter object obj from the list if the list contains it, 
//  null otherwise.  If more than one element matches, the element is lowest position is removed
//  and returned.
    public E remove(E obj) { 
        E tmp = null; 
        int a = find(obj);
        if (a == -1)
            return null;
        else 
            tmp=remove(a);
        currentSize--;
        return tmp;  
    } 
    
//  Removes and returns the first element in the list and null if the it is empty.
    public E removeFirst() { 
           return remove(1);
    }
    
//  Removes and returns the last element in the list and null if the it is empty.
    public E removeLast() {
        return remove(currentSize);
    }      

//  Returns the object located at the parameter position.
//  Throws a RuntimeException if the position does not map to a valid position within 
//  the list.
    public E get(int position) {                    //works.
        if(!isValidPosition(position))
            throw new RuntimeException("invalid location");
        else
            return storage[position-1]; 
    }
    
//  Returns the list object that matches the parameter, and null if the list is empty
//  or if the element is not in the list.  If obj matches more than one element, 
//  the element with the lowest position is returned.
    public E get(E obj) {                           //works.
        int[]list=new int[currentSize];
        
        if (isEmpty()||find(obj)<0)
            return null;
        else{ 
            for (int i=0;i<currentSize;i++){
            list[i]= find(obj);                     //find() returns position#
            }
            return storage[(list[0]-1)];
        }
    }
      
//  Returns the position of the first element that matches the parameter obj
//  and -1 if the item is not in the list.
    public int find(E obj) {                        //works.
        for(int i=0; i < currentSize; i++){
            if(((Comparable<E>)obj).compareTo(storage[i]) == 0)
                return i+1; 
        }
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
            currentSize = 0;   
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
