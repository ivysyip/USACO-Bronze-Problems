import java.util.*;
import java.io.*;
public class TheCowSignal {
    public static void main (String[] args) throws IOException {
        FastIO io = new FastIO("cowsignal.in", "cowsignal.out");
        int M = io.nextInt();
        int N = io.nextInt();
        int K = io.nextInt();
        char[][] newSignal = new char[M * K][N * K];

        for (int i = 0; i < M; i++) {
            String line = io.next();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                for (int a = i * K; a < (i + 1) * K; a++) {
                    for (int b = j * K; b < (j + 1) * K; b++) {
                        newSignal[a][b] = ch;
                    }
                }
            }
        }

        for (int i = 0; i < newSignal.length; i++) {
            for (int j = 0; j < newSignal[i].length; j++) {
                io.print(newSignal[i][j]);
            }
            io.println();
        }
        io.close();
    }
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;

        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1;
            }
            return buf[curChar++];
        }

        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nextInt() {
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
