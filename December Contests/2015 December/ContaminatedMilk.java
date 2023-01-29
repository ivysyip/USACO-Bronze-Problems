import java.util.*;
import java.io.*;

public class ContaminatedMilk {
    public static void main (String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));

        StringTokenizer tokenizer = new StringTokenizer(data.readLine());
        int ppl = Integer.parseInt(tokenizer.nextToken());
        int milk = Integer.parseInt(tokenizer.nextToken());
        int drinks = Integer.parseInt(tokenizer.nextToken());
        int sicks = Integer.parseInt(tokenizer.nextToken());

        HashMap<Integer, ArrayList<Drinks>> drank_per_ppl = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> milk_drank_by = new HashMap<>();

        for (int i = 0; i < drinks; i++) {
            StringTokenizer drink = new StringTokenizer(data.readLine());
            int person = Integer.parseInt(drink.nextToken());
            int milk_drank = Integer.parseInt(drink.nextToken());
            int time = Integer.parseInt(drink.nextToken());

            if (!drank_per_ppl.containsKey(person))
                drank_per_ppl.put(person, new ArrayList<>());
            drank_per_ppl.get(person).add(new Drinks(milk_drank, time));

            if (!milk_drank_by.containsKey(milk_drank))
                milk_drank_by.put(milk_drank, new HashSet<>());
            milk_drank_by.get(milk_drank).add(person);
        }

        HashMap<Integer, HashSet<Integer>> possible = new HashMap<>();
        int test_ppl = 0;
        for (int i = 0; i < sicks; i++) {
            StringTokenizer sick = new StringTokenizer(data.readLine());
            int person = Integer.parseInt(sick.nextToken());
            int time = Integer.parseInt(sick.nextToken());

            if (!possible.containsKey(person)) {
                test_ppl = person;
                possible.put(person, new HashSet<>());
            }

            for (Drinks drink : drank_per_ppl.get(person)) {
                if (drink.time < time)
                    possible.get(person).add(drink.milk);
            }
        }

        HashSet<Integer> works = new HashSet<>();
        for (int test1 : possible.get(test_ppl)) {
            boolean work = true;
            for (int others : possible.keySet())
                work = work && possible.get(others).contains(test1);

            if (work)
                works.add(test1);
        }

        int max = 0;
        for (int find : works)
            max = Math.max(max, milk_drank_by.get(find).size());

        out.println(max);
        out.close();
        data.close();
    }

    static class Drinks {
        int milk;
        int time;

        public Drinks (int milk, int time) {
            this.milk = milk;
            this.time = time;
        }
    }
}
