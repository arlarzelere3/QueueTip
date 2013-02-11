/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queue.tip;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author alarzele
 */
public class QueueTip {

    public enum charType {

        LETTER, NUMBER
    };
    private char[] values = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private LinkedHashSet<Character> letters = new LinkedHashSet<Character>();
    private LinkedHashSet<Character> numbers = new LinkedHashSet<Character>();

    public LinkedHashSet<Character> getLetters() {
        return letters;
    }

    public void setLetters(LinkedHashSet<Character> letters) {
        this.letters = letters;
    }

    public LinkedHashSet<Character> getNumbers() {
        return numbers;
    }

    public void setNumbers(LinkedHashSet<Character> numbers) {
        this.numbers = numbers;
    }

    public char[] getValues() {
        return values;
    }

    public void setValues(char[] values) {
        this.values = values;
    }

    public QueueTip() {
    }

    @Override
    public String toString() {
        return String.valueOf(values);
    }

    public String execute(String[] input) throws Exception {
        if (input.length == 0) {
            return this.toString();
        } else {
            char[] output = {'-', '-', '-', '-', '-', '-', '-', '-'};
            loadInstructions(input);
            try {
                if (letters.size() != numbers.size()) {
                    throw new Exception("Invalid input: Number of letters and number not equal");
                } else if (!validateLetters(letters) || !validateNumbers(numbers)) {
                    throw new Exception("Invalid input: Duplicate or not present letters or numbers");
                } else {
                    //Execute Individual instructions
                    Iterator<Character> numItr = numbers.iterator();
                    Iterator<Character> charItr = letters.iterator();

                    while (numItr.hasNext() && charItr.hasNext()) {
                        output[Character.getNumericValue((Character) numItr.next())] = (Character) charItr.next();
                    }

                    //Fill in missing values
                    for (char currChar : values) {
                        boolean found = charArrayContains(output, currChar);

                        if (!found) {
                            for (int i = 0; i < output.length; i++) {
                                if (output[i] == '-') {
                                    output[i] = currChar;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
            return String.valueOf(output);
        }
    }

    public boolean canConvertToChar(String input) {
        return input.length() == 1;
    }

    public charType letterOrNumber(char input) {
        return Character.isDigit(input) ? charType.NUMBER : charType.LETTER;
    }

    public void loadInstructions(String[] inputStrings) {
        try {
            for (String i : inputStrings) {
                if (canConvertToChar(i)) {
                    switch (letterOrNumber(i.charAt(0))) {
                        case LETTER:
                            if (!letters.add(Character.toUpperCase(i.charAt(0)))) {
                                throw new Exception("Invalid input: duplicate letter");
                            }
                            break;

                        case NUMBER:
                            if (!numbers.add(i.charAt(0))) {
                                throw new Exception("Invalid input: duplicate number");
                            }
                            break;
                        default:
                            throw new Exception("Invalid input: not letter or character: " + i);
                    }
                } else {
                    throw new Exception("Invalid input: Not a character: " + i);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public boolean validateLetters(LinkedHashSet<Character> inputLetters) {
        Iterator<Character> inputItr = inputLetters.iterator();
        while (inputItr.hasNext()) {
            if (!charArrayContains(values, (Character) inputItr.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean validateNumbers(LinkedHashSet<Character> inputNumbers) {
        Iterator<Character> inputItr = inputNumbers.iterator();
        Integer currNum;
        while (inputItr.hasNext()) {
            currNum = Character.getNumericValue((Character) inputItr.next());
            if (currNum >= values.length || currNum < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean charArrayContains(char[] array, char input) {
        boolean notFound = true;
        for (char outSearch : array) {
            if (input == outSearch) {
                notFound = false;
            }
        }
        return !notFound;
    }
}
