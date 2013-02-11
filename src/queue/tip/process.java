/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queue.tip;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alarzele
 */
public class process {

    /**
     * @param args the command line arguments
     */
            // Queues used to store and organize input

    
    public static void main(String[] args) {
        // Queues used to store and organize input
        Queue<Character> numbers = new LinkedList<Character>();	
        Queue<Character> letters = new LinkedList<Character>();
        
        // LinkedHashSet used for output
        LinkedHashSet<Character> results = new LinkedHashSet<Character>();
        results.add('a');
        results.add('b');
        results.add('c');
        results.add('d');
        results.add('e');
        results.add('f');
        results.add('g');
        
        System.out.println(results);
        System.out.println("Results size: " + results.size());
        
        //Get input
	char[] input = args[0].toCharArray();
        
        System.out.println(input);
        
        
        //Load input into queues
        for (char i: input)
        {
            if (Character.isDigit(i))
            {
                    numbers.add(i);
            }
            else if (results.contains(i))
            {
                
                letters.add(i);
            }
            else
            {
                System.out.println("Input " + i + " is invalid");
            }
        }
	
        
        System.out.println(letters);
        System.out.println(numbers);
        
        System.out.println("First Command: " + letters.peek() + " " + numbers.peek());
        
        if (letters.size() != numbers.size())
        {
            System.out.println("Input is invalid");
        }
        else
        {
            System.out.println("Input is valid");
        }
        
    }
    
}