/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

/*  Tester for program #1.  This simple tester/driver is just a sample.
    The fact that your program might run without errors with this driver
    does not in any way guarantee that it is error free.  You are responsible
    for testing your program.
    Alan Riggins
    CS310 Summer 2017
    Program #1
*/    


import data_structures.*;

public class Tester {
    private UnorderedListADT<String> list;
    
    public Tester() {
        list = new UnorderedVector<String>();
        runTests();
        }
        
    private void runTests() {
    try {
        for(int i=1; i <= 10; i++) 
            list.addFirst(i+"");
        System.out.print("Should now print 10 .. 1: ");
        for(String s : list)
            System.out.print(" "+s);
        System.out.println();
        for(int i=1; i <= 10; i++) 
            if(list.removeFirst() == null)
                throw new RuntimeException("ERROR with removeFirst");
        for(String s : list) 
            System.out.println("ERROR, iterator failure");
            
        if(!list.isEmpty())
            throw new RuntimeException("ERROR in inEmpty");  
        if(list.size() != 0)
            throw new RuntimeException("ERROR in size");
            
        for(int i=1; i <= 1000; i++) {
            for(int j=1; j <= 7; j++)
                list.addFirst(j+"");
            for(int j=1; j <= 7; j++)                
                list.removeLast();
            }
            
        for(int i=1; i <= 1000; i++) {
            for(int j=1; j <= 7; j++)
                list.addLast(j+"");
            for(int j=1; j <= 7; j++)                
                list.removeFirst();
            }
            
        list.addFirst("foo");
        if(list.find("foo") == -1)   
            throw new RuntimeException("ERROR in find");
        list.addLast("bar");
        if(list.find("bar") == -1)   
            throw new RuntimeException("ERROR in find"); 
            
        list.clear();
        
        for(int i=1; i <= 10; i++)
            list.addFirst(""+i);
            
        System.out.print("The list now contains:");
        for(String s : list)
            System.out.print(" "+s);
        System.out.println();
            
        for(int i=10; i <= 1; i--)
            if(list.find(""+i) != i)
                throw new RuntimeException("ERROR in find, did not find "+i+ " got: " 
                + list.find(""+i)); 
                
        for(int i=1; i <= 10; i++)
            if(!list.contains(i+""))
                throw new RuntimeException("ERROR in contains");   
                
        list.addFirst("Henry");
        list.addFirst("Johnny");
        list.addLast("Samuel");
        list.addLast("Robert");
        if(list.get("Alan") != null)
            throw new RuntimeException("ERROR, unsuccessful search failed");  
        System.out.println("Expecting: \nThe list now contains: Johnny Henry "+
            "10 9 8 7 6 5 4 3 2 1 Samuel Robert");
        System.out.println("Your output:");
        System.out.print("The list now contains:");
        for(String s : list)
            System.out.print(" "+s);
        System.out.println(); 
        for(int i=0; i < 1000000; i++)
            list.addLast(""+i);
        list.clear(); 
        for(int i=0; i < 1000; i++)
            list.addFirst(""+i);                                            
       }
       catch(Exception e) {
           System.out.println(e);
           e.printStackTrace();
           }
                                           
       }
        
    public static void main(String [] args) {
        new Tester();
        }
    }