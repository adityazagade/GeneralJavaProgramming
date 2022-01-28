package com.azagade.streams;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class main1 {

    public static void main(String[] args) throws java.lang.Exception {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        while (T-- > 0) {
            int n = fr.nextInt();
            int[] ig = new int[1001];
            boolean recepie = true;
            int count = 0;
            int previousNum = -1;
            for (int j = 0; j < n; j++) {
                int num = fr.nextInt();
                if (ig[num] != 0) {
                    recepie = false;
                    break;
                } else if (num == previousNum) {
                    count++;
                } else {
                    if (previousNum == -1) {
                        previousNum = num;
                        count = 1;
                    } else {
                        ig[previousNum] = count;
                        previousNum = num;
                        count = 1;
                    }

                }
            }

            if (recepie) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();

        }

        public String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (Exception e) {

            }
            return line;
        }
    }
}