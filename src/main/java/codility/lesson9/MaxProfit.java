package codility.lesson9;

public class MaxProfit {

    public static void main(String[] args) {
        //  A[0] = 23171
        //  A[1] = 21011
        //  A[2] = 21123
        //  A[3] = 21366
        //  A[4] = 21013
        //  A[5] = 21367
        System.out.println(solution(new int[]{
                23171,
                21011,
                21123,
                21366,
                21013,
                21367,
        }));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 1 || A.length == 0) {
            return 0;
        }

        int[] maxA = new int[A.length];

        int maxPrice = A[A.length - 1];
        maxA[A.length - 1] = maxPrice;

        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > maxPrice) {
                maxPrice = A[i];
            }
            maxA[i] = maxPrice;
        }

        int answer = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < maxA[i+1]) {
                if(maxA[i+1] - A[i] > answer) {
                    answer = maxA[i+1] - A[i];
                }
            }
        }

        return answer;

    }

}
