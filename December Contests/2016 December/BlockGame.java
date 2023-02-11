import java.util.*;
import java.io.*;

public class BlockGame {
    public static void main (String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int boards = Integer.parseInt(data.readLine());
        int[] blocks = new int[26];

        for (int i = 0; i < boards; i++) {
            StringTokenizer tokenizer = new StringTokenizer(data.readLine());
            String first_word = tokenizer.nextToken();
            String second_word = tokenizer.nextToken();

            int[] first_require = check(first_word);
            int[] second_require = check(second_word);

            for (int n = 0; n < 26; n++) {
                blocks[n] += Math.max(first_require[n], second_require[n]);
            }
        }

        for (int num : blocks) {
            out.println(num);
        }

        out.close();
        data.close();
    }

    static int[] check(String word) {
        int[] need = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            need[ch-97]++;
        }

        return need;
    }
}
