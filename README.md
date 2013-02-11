Queue Tip Problem

(This is not my puzzle, if you know who created it please email me at alarzelere@gmail.com and I will attribute it thusly)

Imagine a queue that looks like the following:
A B C D E F G H
A is in slot 0 of the queue, and H is in slot 7.  The alphabet gods have 
now told you to defy the order of this queue on-demand.  Your task is 
to write a program that accepts pairs of values, one being a slot 
number, and the other being a letter.  The program should be able to 
accept any even combination of unique slot numbers and letters, 
which pairs in the order of letters and numbers received, and should 
throw an error if an odd number of arguments are passed or if a slot 
number and letter are used more than once in the argument list.  
Based on the input, the queue will change, and you will output the new 
queue.  Any letters that are not defined in the arguments passed 
should move into the open slots in alphabetical order (much like a 
queue, ironically).  If no arguments are passed, the original queue should output.  
It is also safe to throw an error if a letter that doesn’t 
exist in the queue is passed, and also if a slot number is passed that is 
larger than the size of the queue.  
Example input:
Myprog 3 A B 5 
Expected output:
C D E A F B G H
Example input:
Myprog A H 1 6 7 E
Expected output:
B A C D F G H E
Bad inputs:
Myprog A 1 A 2 
Myprog A 1 B 3 C
