import java.awt.*;
import java.util.*;
import java.io.*;

public class SquarePasture {
    public static void main(String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        ArrayList<Rectangle> pastures = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringTokenizer tokenizer = new StringTokenizer(data.readLine());

            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            pastures.add(new Rectangle(x1, y1, x2-x1, y2-y1));
        }

        Rectangle union = pastures.get(0).union(pastures.get(1));

        double max = Math.max(union.getHeight(), union.getWidth());

        out.println((int)Math.pow(max, 2));
        out.close();
        data.close();
    }
}
