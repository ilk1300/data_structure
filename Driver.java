/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data_structures.*;
import java.util.Iterator;

public class Driver {
	UnorderedListADT<String> list;
	
	public Driver() {
	    list = new UnorderedVector<String>();
	    runTests();
	}
	
	private void runTests() {
	    list.addLast("Henry");
	    list.addLast("Joseph");
	    list.addLast("Tam");
	    list.addLast("980");
	    for(int i=0; i < 996; i++)
	        list.addLast(i+"");
//	   Iterator iter = list.iterator();
//	    while(iter.hasNext())
//	    	System.out.println(iter.next());
	    for(String s : list)
	        System.out.println(s);
	    if(list.contains("980"))
	    	System.out.println("FOUND HENRY");
	    else 
	    	System.out.println("NO HENRY :(");	    
	}
	
	
	public static void main(String [] args) {
	    new Driver();
	    }
}