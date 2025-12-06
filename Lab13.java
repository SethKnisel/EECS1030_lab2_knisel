import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean[] chptList = new boolean[16];  // Valid chapters: 1–15
        int includeChpt;
        int i, j;

        // Get the chapter selections (1 = include, 0 = exclude)
        for (i = 1; i <= 15; ++i) {
            includeChpt = scnr.nextInt();
            if (includeChpt == 1) {
                chptList[i] = true;
            }
            else {
                chptList[i] = false;
            }
        }

        /* Type your code here. */
        boolean printedAny = false;

        i = 1;
        while (i <= 15) {

            // If chapter is NOT selected, move to next
            if (!chptList[i]) {
                i++;
                continue;
            }

            // Chapter IS selected → treat this as the start of a possible range
            int start = i;
            int end = i;

            // Extend the range while the following chapters are also selected
            while (end + 1 <= 15 && chptList[end + 1]) {
                end++;
            }

            // Determine range size
            int length = end - start + 1;

            if (length >= 3) {
                // Print compressed range
                System.out.print(start + "-" + end + " ");
            } 
            else {
                // Print individually for 1 or 2 chapters
                for (j = start; j <= end; j++) {
                    System.out.print(j + " ");
                }
            }

            printedAny = true;

            // Jump index to end of processed range
            i = end + 1;
        }

        // If no chapters were selected
        if (!printedAny) {
            System.out.print("None ");
        }

        System.out.println();
    }
}