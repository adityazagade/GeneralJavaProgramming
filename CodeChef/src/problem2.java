import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem2 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        HashMap<String, String> map = new HashMap<>();
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};

        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();
            int index = i + 1;
            int size = array.length;
            while (size != 1) {
                size = size / 2;
                if (size == 1) {
                    if (index == 1) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                    break;
                }
                if (index <= size) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    index = index - size;
                }
            }
            if (map.get(sb.toString()) != null) {
                System.out.println(sb.toString() + ":" + map.get(sb.toString()));
            }
            map.put(sb.toString(), array[i]);
        }
        while (t-- > 0) {
            int length = fr.nextInt();
            String line = fr.nextLine();
            int words = length / 4;
            StringBuilder sb1 = new StringBuilder();
            for (int i = 1; i <= words; i++) {
                StringBuilder sb = new StringBuilder();
                int n = (i-1)*4;
                sb.append(line.charAt(n));
                sb.append(line.charAt(n + 1));
                sb.append(line.charAt(n + 2));
                sb.append(line.charAt(n + 3));
                String code = sb.toString();
                sb1.append(map.get(code));
            }
            System.out.println(sb1.toString());
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

