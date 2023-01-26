import java.util.*;
import java.io.*;

public class FencePainting {
    public static void main (String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer farmer = new StringTokenizer(data.readLine());
        StringTokenizer bessie = new StringTokenizer(data.readLine());

        int farmer_start = Integer.parseInt(farmer.nextToken());
        int farmer_end = Integer.parseInt(farmer.nextToken());
        int bessie_start = Integer.parseInt(bessie.nextToken());
        int bessie_end = Integer.parseInt(bessie.nextToken());

        boolean [] farmers = new boolean[101];

        for (int i = farmer_start; i < farmer_end; i++) {
            farmers[i] = true;
        }

        int count = 0;
        for (int i = 0; i < 101; i++) {
            if ((i >= bessie_start && i < bessie_end) || farmers[i])
                count++;
        }

        out.println(count);
        out.close();
        data.close();
    }
}
