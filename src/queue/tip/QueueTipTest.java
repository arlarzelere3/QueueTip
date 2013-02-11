/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queue.tip;

import java.util.LinkedHashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alarzele
 */
public class QueueTipTest {
    
    private QueueTip qt;
    
    public QueueTipTest() {
    }

    @Before
    public void setUp() {
        qt = new QueueTip();
    }

    @Test
    public void testValues()
    {
        assertEquals("ABCDEFGH", qt.toString());
    }
    
    @Test
    public void testExecute() throws Exception
    {
        String[] invalidInput = new String[0];
        String[] validInput = {"3", "A", "2", "D"};
        assertEquals("ABCDEFGH", qt.execute(invalidInput));
        assertEquals("BCDAEFGH", qt.execute(validInput));
    }
    
    @Test
    public void testCanConvertToChar()
    {
        assertTrue(qt.canConvertToChar("A"));
        assertTrue(qt.canConvertToChar("1"));
        assertFalse(qt.canConvertToChar("BALL"));
    }
    
    @Test
    public void testLetterOrNumber()
    {
        assertEquals(QueueTip.charType.LETTER, qt.letterOrNumber('A'));
        assertEquals(QueueTip.charType.NUMBER, qt.letterOrNumber('3'));
    }
    
    @Test
    public void testLoadInstructions(){
        String[] input = {"a", "1", "b", "2"};
        qt.loadInstructions(input);
        assertEquals("[A, B]", qt.getLetters().toString());
        assertEquals("[1, 2]", qt.getNumbers().toString());
    }
    
    @Test
    public void validateLetters(){
        LinkedHashSet<Character> testLetters = new LinkedHashSet<Character>();
        testLetters.add('H');
        testLetters.add('G');
        //testLetters.add('g');
        
        assertTrue(qt.validateLetters(testLetters));
        
        testLetters.add('X');
        
        assertFalse(qt.validateLetters(testLetters));
    }
    
    @Test
    public void validateNumbers(){
        LinkedHashSet<Character> testNumbers = new LinkedHashSet<Character>();
        testNumbers.add('3');
        testNumbers.add('1');
        //testNumbers.add('3');
        
        assertTrue(qt.validateNumbers(testNumbers));
        
        testNumbers.add('9');
        
        assertFalse(qt.validateNumbers(testNumbers));
    }
    
    @Test
    public void testcharArrayContains(){
        char[] values = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        assertTrue(qt.charArrayContains(values, 'a'));
        assertFalse(qt.charArrayContains(values, 'x'));
    }
}
