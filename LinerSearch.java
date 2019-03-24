package algo.search;

import java.util.Scanner;

/**
 * Linear search is the most basic search algorithm for the sorted array search.
 * Complexity O(n)
 */
public class LinerSearch {
    Object elements[];
    private int size;
    private int index = 0;

    public LinerSearch(int size) {
        this.size = size;
        elements = new Object[size];
    }

    public void insertElement(Object element) throws Exception {
      if (index == size) {
          throw new Exception("Size exceeded");
      }
      elements[index] = element;
      index++;
    }

    public int getElementIndex(Object element) {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]+"**");
            if ((elements[i].equals(element)))
                return i+1;
        }
        return -1;
    }

    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for (int j = 0; j < numTestCases; j++) {
            int n = in.nextInt();
            LinerSearch search =
                    new LinerSearch(n);
            int elementToSearch = in.nextInt();
            for (int i = 0; i < n; i++) {
                int element = in.nextInt();
                search.insertElement(element);
            }
            System.out.println(search.getElementIndex(elementToSearch));
        }
    }
}
