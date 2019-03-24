package algo.search;

import java.util.Scanner;

/**
 * Binary search is the efficient search algorithm for the numerical sorted array search.
 * Complexity O(logn)
 */
public class BinarySearch {
    int elements[];
    private int size;
    private int index = 0;

    public BinarySearch(int size) {
        this.size = size;
        elements = new int[size];
    }

    public void insertElement(int element) throws Exception {
        if (index == size) {
            throw new Exception("Size exceeded");
        }
        elements[index] = element;
        index++;
    }

    public int binarySearch(int element) {
        int low = 0, high = index;
        while (low <= high) {
            int middle = Math.round((low + high)/2);
            if (element == elements[middle]) {
                return 1;
            } else if (element > elements[middle]) {
                low = middle + 1;
            } else if (element < elements[middle]) {
                high = middle -1;
            }
        }
        return -1;

    }

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for (int j = 0; j < numTestCases; j++) {
            int n = in.nextInt();
            BinarySearch search =
                    new BinarySearch(n);
            int elementToSearch = in.nextInt();
            for (int i = 0; i < n; i++) {
                int element = in.nextInt();
                search.insertElement(element);
            }
            System.out.println(search.binarySearch(elementToSearch));
        }
    }
}
