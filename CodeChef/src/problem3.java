import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem3 {
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
            int m = fr.nextInt();
            String[] tempN = fr.nextLine().split(" ");
            String[] tempM = fr.nextLine().split(" ");
            LinkedList<Integer> listM = new LinkedList<>();
            LinkedList<Integer> listN = new LinkedList<>();
            int countMin = Math.min(n, m);

            int sumN = 0;
            int sumM = 0;
            int minSwitch = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(tempN[i]);
                listN.add(num);
                sumN += num;
            }

            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(tempM[i]);
                listM.add(num);
                sumM += num;
            }

            if (sumN > sumM) {
                System.out.println(minSwitch);
            } else {
                Collections.sort(listN);
                Collections.sort(listM);
                while (countMin > 0 && sumN <= sumM) {
                    int voteN = listN.get(0);
                    int voteM = listM.get(listM.size() - 1);
                    listN.remove(0);
                    listM.remove(listM.size() - 1);
                    sumN = sumN - voteN + voteM;
                    sumM = sumM - voteM + voteN;
                    countMin--;
                    minSwitch++;
                }
                if (sumN > sumM) {
                    System.out.println(minSwitch);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
