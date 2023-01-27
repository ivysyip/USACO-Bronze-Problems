import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main (String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        StringTokenizer tokenizer = new StringTokenizer(data.readLine());
        int road_seg = Integer.parseInt(tokenizer.nextToken());
        int cow_seg = Integer.parseInt(tokenizer.nextToken());

        int[] diff = new int[100];

        int index = 0;
        for (int i = 0; i < road_seg; i++) {
            StringTokenizer road_speed = new StringTokenizer(data.readLine());
            int length = Integer.parseInt(road_speed.nextToken());
            int speed = Integer.parseInt(road_speed.nextToken());

            for (int n = index; n < index + length; n++) {
                diff[n] = speed;
            }

            index += length;
        }

        int max = 0;
        index = 0;
        for (int i = 0; i < cow_seg; i++) {
            StringTokenizer cow_speed = new StringTokenizer(data.readLine());
            int length = Integer.parseInt(cow_speed.nextToken());
            int speed = Integer.parseInt(cow_speed.nextToken());

            for (int n = index; n < index + length; n++) {
                max = Math.max(max, speed - diff[n]);
            }

            index += length;
        }

        out.println(max);
        out.close();
        data.close();
    }
}
