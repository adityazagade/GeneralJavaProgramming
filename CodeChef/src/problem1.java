import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int d = fr.nextInt();
            int sum = 0;
            int days = 0;
            for (int i = 0; i < n; i++) {
                sum += fr.nextInt();
                days += sum / k;
                sum = sum % k;
                if (days >= d) {
                    days = d;
                    break;
                }
            }
            System.out.println(days);
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }

    }
}
