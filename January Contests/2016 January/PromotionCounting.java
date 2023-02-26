import java.util.*;
import java.io.*;

public class PromotionCounting {
    public static void main (String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        int[] initial = new int[4];
        int[] new_list = new int[4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer tokenizer = new StringTokenizer(data.readLine());

            initial[i] = Integer.parseInt(tokenizer.nextToken());
            new_list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] cal = new int[3];

        for (int i = 3; i > 0; i--) {
            int change = new_list[i] - initial[i];

            initial[i-1] -= change;
            cal[i-1] = change;
        }

        for (int num : cal) {
            out.println(num);
        }

        out.close();
    }
}
