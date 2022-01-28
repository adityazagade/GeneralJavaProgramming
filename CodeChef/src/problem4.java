import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem4 {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int x = fr.nextInt();
            int y = fr.nextInt();

            if (x == y) {
                System.out.println(n + " " + n);
            } else {
                Point p1;
                Point p2;
                Point p3;
                Point p4;
                ArrayList<Point> intersections = new ArrayList<>();
                //check if point is below or above.
                boolean isAbove = true;
                if (x > y) {
                    isAbove = false;
                }
                //define 4 lines.
                if (isAbove) {
                    // y = x + (b-a);
                    // x = 0;
                    // y = n;
                    p1 = new Point(n + x - y, n);
                    p4 = new Point(0, y - x);
                    p2 = new Point(n, n + x - y);
                    p3 = new Point(y - x, 0);
                } else {
//                    x = n;
//                    y = 0;
                    p1 = new Point(n, n + y - x);
                    p4 = new Point(x - y, 0);
                    p2 = new Point(n + y - x, n);
                    p3 = new Point(0, x - y);
                }
                intersections.add(p1);
                intersections.add(p2);
                intersections.add(p3);
                intersections.add(p4);

                int n1 = k % 4;
                if (n1 == 0) n1 = 4;
                Point ans = intersections.get(n1-1);
                System.out.println(ans.x + " " + ans.y);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
