// 2702337230
// B. Bellion Leander


import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TOH toh = new TOH(8);
    }
}


class TOH {

    // towers / rods
    static Stack<Integer> aRod = new Stack<>();
    static Stack<Integer> cRod = new Stack<>();
    static Stack<Integer> bRod  = new Stack<>();

    // stores stacks to help print in parallel
    static ArrayList<Stack<Integer>> towArr = new ArrayList<>();

    // num of disks
    static int n;

    // counts recursions / steps taken
    static int count = 0;

    public TOH(int n) {
        TOH.n = n;
        // Adds "disks" to first rod
        for(int i = n; i > 0; i--) {
            aRod.push(i);
        }
        towArr.add(aRod); towArr.add(bRod); towArr.add(cRod);

        solve(n, aRod, cRod, bRod);

        System.out.println(count + " steps");
    }

    private static void solve(int n, Stack<Integer> fromRod, Stack<Integer> nextRod, Stack<Integer> auxRod) {

        // base case
        if(n == 0) {
            return;
        }

        // move n-1 rod from fromRod to nextRod
        solve(n-1, fromRod, auxRod, nextRod);
        nextRod.push(fromRod.pop());

        // Prints towers
        for(int i = TOH.n-1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();

            // prints element at current index for all 3 towers
            for (Stack<Integer> tow : TOH.towArr) {
                try {
                    sb.append(tow.get(i)).append("  ");
                } catch(Exception e) {
                    sb.append(" ").append("  ");
                }
            }
            System.out.println(sb);
        }
        System.out.println("_  _  _\n\n");

        solve(n-1, auxRod, nextRod, fromRod);

        TOH.count++;
    }
}
