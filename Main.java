
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// main
public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a word (using stuck): ");
        StackPalindromeChecker sPC = new StackPalindromeChecker();
        System.out.println(sPC.getPalindrome()+"\n");

        System.out.println("Enter a word (using queeue): ");
        QueuePalindromeChecker qPC = new QueuePalindromeChecker();
        System.out.println(qPC.getPalindrome());
    }

    public static String getStrInput(Scanner scan){
        return scan.nextLine();
    }
}

// Palindrome checker using stack
class StackPalindromeChecker {
    private static Stack<Character> myStack = new Stack<>();
    private boolean isPalindrome = true; // default is true

    public StackPalindromeChecker() {
        // Gets user input and stores it in a char array
        String str = Main.getStrInput(Main.scan);
        char[] charArr = str.toCharArray();
        float mid = (float)str.length()/2;

        // Pushes first half of the string
        for(int i = 0; i < (int)mid; i++){
            myStack.push(charArr[i]);
        }

        // Pops stack and compares with 2nd half of char array
        for(int j = (int)(mid + 0.5); j < str.length(); j++){
            if(charArr[j] != myStack.pop()){
                isPalindrome = false;
                break;
            }
        }
    }

    public boolean getPalindrome(){
        return isPalindrome;
    }
}

// Palindrome checker using Queueeue
class QueuePalindromeChecker {
    private static Queue<Character> myQ = new LinkedList<>();
    private boolean isPalindrome = true;

    public QueuePalindromeChecker(){
        // Gets user input and stores it in an array
        String str = Main.getStrInput(Main.scan);
        char[] charArr = str.toCharArray();
        float mid = (float)str.length()/2;

        // Adds first half of char array
        for(int i = 0; i < (int)mid; i++){
            myQ.add(charArr[i]);
        }

        // Polls each char and compares with the 2nd half
        for(int j = str.length()-1; j > (int)mid; j--){
            if(charArr[j] != myQ.poll()){
                isPalindrome = false;
                break;
            }
        }
    }

    public boolean getPalindrome(){
        return isPalindrome;
    }


}