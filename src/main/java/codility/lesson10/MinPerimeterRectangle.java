package codility.lesson10;

public class MinPerimeterRectangle {

    public static void main(String[] args) {

    }

    public int solution(int N) {
        // write your code in Java SE 8
        //즉 제곱근까지의 반까지 나눠지는 갯수 x 2 = 총 개수
        double sqrt = Math.sqrt(N);
        int first = 1;
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                first = i;
            }
        }
        int last = N / first;


        return 2 * (first + last);
    }

    public int solution2(int N) {
        // write your code in Java SE 8

        int answer = -1;
        int befB = -1;
        int aftA = -1;

        for(int i = 1; i <= N / 2 +1; i++) {
            if(N % i == 0) {
                int A = i;
                int B = N / i;

                aftA = A;
                if(befB == aftA) {
                    break;
                } else {
                    befB = B;
                }

                int perimeter = getPerimeter(A, B);
                if(answer == -1) {
                    answer = perimeter;
                } else {
                    if(answer > perimeter) {
                        answer = perimeter;
                    }
                }
            }

        }

        return answer;
    }

    public static int getPerimeter(int A, int B) {
        return 2 * (A + B);
    }

}
