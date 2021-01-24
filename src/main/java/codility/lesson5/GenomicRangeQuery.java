package codility.lesson5;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        int[] result = Solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] Solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] result = new int[P.length];
        int[][] toArray = new int[S.length()][4];

        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        for(int i = 0; i < S.length(); i++) {
            String checkStr = S.substring(i, i + 1);
            if(checkStr.equals("A")) {
                A++;
            } else if(checkStr.equals("C")) {
                C++;
            } else if(checkStr.equals("G")) {
                G++;
            } else {
                T++;
            }
            toArray[i] = new int[]{A, C, G, T};
        }

        int M = P.length;
        for(int K = 0; K < M; K++) {
            int PK = P[K];
            int QK = Q[K];

            int[] comA = null;
            if(PK == 0) {
                comA = new int[]{0, 0, 0, 0};
            } else {
                comA = toArray[PK - 1];
            }

            int[] fromA = new int[]{
                    toArray[PK][0] - comA[0],
                    toArray[PK][1] - comA[1],
                    toArray[PK][2] - comA[2],
                    toArray[PK][3] - comA[3]
            };

            int[] toA = new int[]{
                    toArray[QK][0] - comA[0],
                    toArray[QK][1] - comA[1],
                    toArray[QK][2] - comA[2],
                    toArray[QK][3] - comA[3]
            };

            for(int i = 0; i < 4; i++) {
                if(fromA[i] != 0 || toA[i] != 0) {
                    if(i == 0) {
                        result[K] = 1;
                        break;
                    } else if (i == 1) {
                        result[K] = 2;
                        break;
                    } else if (i == 2) {
                        result[K] = 3;
                        break;
                    } else {
                        result[K] = 4;
                        break;
                    }
                }
            }
        }

        return result;
    }

}

// you can also use imports, for example:
//import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//    public int[] solution(String S, int[] P, int[] Q) {
//        // write your code in Java SE 8
//        int[] result = new int[P.length];
//        int M = P.length;
//
//        for(int K = 0; K < M; K++) {
//            int PK = P[K];
//            int QK = Q[K];
//
//            String checkStr = S.substring(PK, QK + 1);
//            char[] charS = checkStr.toCharArray();
//            Arrays.sort(charS);
//            result[K] = getValue(String.valueOf(charS[0]));
//        }
//
//        return result;
//    }
//
//    public static int getValue(String s) {
//        if(s.equals("A")) {
//            return 1;
//        }else if(s.equals("C")) {
//            return 2;
//        } else if (s.equals("G")) {
//            return 3;
//        } else if (s.equals("T")) {
//            return 4;
//        } else {
//            return 0;
//        }
//    }
//}


// // you can also use imports, for example:
// import java.util.*;

// // you can write to stdout for debugging purposes, e.g.
// // System.out.println("this is a debug message");

// class Solution {
//     public int[] solution(String S, int[] P, int[] Q) {
//         // write your code in Java SE 8
//         // A 1
//         // C 2
//         // G 3
//         // T 4
//         int M = P.length;  // 쿼리
//         int[] result = new int[M];
//         int N = S.length();
//         Set<String> set = null;
//         String[] sA = null;
//         // Map<String,
//         for(int K = 0; K < M; K++) {
//             int PK = P[K];
//             int QK = Q[K];
//             // System.out.println(PK);
//             // System.out.println(QK);
//             // System.out.println("--");

//             if(PK >= N) {
//                 result[K] = 0;
//                 continue;
//             } else if(QK >= N) {
//                 QK = N - 1;
//             }

//             sA = new String[QK - PK + 1];
//             int j = 0;
//             for(int i = PK; i <= QK; i++, j++) {
//                 sA[j] = S.substring(i, i+1);
//             }
//             result[K] = getValue(sA);

//         }

//         return result;
//     }

//     public static int getValue(String[] sA) {
//         Arrays.sort(sA);

//         String s = sA[0];
//         if(s.equals("A")) {
//             return 1;
//         }else if(s.equals("C")) {
//             return 2;
//         } else if (s.equals("G")) {
//             return 3;
//         } else if (s.equals("T")) {
//             return 4;
//         } else {
//             return 0;
//         }
//     }
// }
