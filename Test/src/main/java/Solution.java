import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int totalPol = 0;
        for (int i = 0; i < A.length; i++) {
            totalPol += A[i];
        }
        Arrays.sort(A);
        int numFilters = 0;
        int poldecreased = 0;
        while (poldecreased < totalPol / 2) {
            int i = 1;
            int lastElement = A.length - 1;
            int secondLastElement = A.length - 2;
            while ((A[lastElement] / (int) Math.pow(2, i) > A[secondLastElement])) {
                if (poldecreased + (A[lastElement] / (int) Math.pow(2, i)) >= totalPol / 2) {
                    return numFilters + i;
                }
                i++;
            }
            numFilters += i;
            int t = A[lastElement];
            A[lastElement] = A[lastElement] / (int) Math.pow(2, i);
            poldecreased += t - A[lastElement];
            int j = secondLastElement;
            while (j >= 0 && (A[j] > A[j + 1])) {
                int tm = A[j];
                A[j] = A[j + 1];
                A[j + 1] = tm;
                j--;
            }
        }
        return numFilters;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).solution(new int[]{5, 19, 8, 1}));
        System.out.println((new Solution()).solution(new int[]{10,10}));
        System.out.println((new Solution()).solution(new int[]{3, 0, 5}));
        System.out.println((new Solution()).solution(new int[]{10, 0, 0}));
    }
}
