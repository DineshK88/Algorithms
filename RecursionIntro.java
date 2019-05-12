package algo.recursion;

/**
 * Recursion as a solution to be used when a problem can be divided into the
 * subproblems amd result of subproblem can be used in the original problem.
 *
 * Recursion generally has parts - One or more base condition and self calling function.
 */
public class RecursionIntro {
    private void printSomething(int count) {
        if (count == 0) {
            return;
        }
        System.out.println("Printed number"+count);
        printSomething(count - 1);
    }

    public static void main(String args[]) {
        RecursionIntro intro = new RecursionIntro();
        intro.printSomething(7);
    }

}
