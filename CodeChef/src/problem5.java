//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//class problem5 {
//    static class FastReader {
//        StringTokenizer st;
//        BufferedReader br;
//
//        FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        String nextLine() {
//            String line = "";
//            try {
//                line = br.readLine();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return line;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        FastReader fr = new FastReader();
//        int t = fr.nextInt();
//        while (t-- > 0) {co
//            int k = fr.nextInt();
//            ArrayList<Integer> al = new ArrayList<>(n);
//            for (int i = 0; i < n; i++) {
//                al.add(Integer.parseInt(fr.next()));
//            }
//            Collections.sort(al, Collections.reverseOrder());
//            int[] sum = new int[n + 1];
//            for (int i = 0; i < al.size(); i++) {
//                sum[i + 1] = al.get(i);
//            }
//            int[][] tmp = new int[n + 1][k + 1];
//            for (int i = 1; i < n + 1; i++) {
//                for (int j = 1; j < k + 1; j++) {
//                    int num = al.get(i - 1);
//                    if (i - 1 > 0 && j - num > 0) {
//                        tmp[i][j] = Math.min(num + tmp[i - 1][j - num], tmp[i - 1][j]);
//                    } else {
//                        tmp[i][j] = Math.min(num + tmp[i - 1][j - num], tmp[i - 1][j]);
//                    }
//                }
//            }
//        }
//    }
//}