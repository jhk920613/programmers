package programmers.level2;

import util.GsonUtil;

// https://programmers.co.kr/learn/courses/30/lessons/1829
public class KakaoFriendsColoringBook {

    public static void main(String[] args) {
        KakaoFriendsColoringBook s = new KakaoFriendsColoringBook();

        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        // [4,5]
        GsonUtil.toJsonPrint(s.solution(m, n, picture));
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        boolean[][] visit = new boolean[m][n];

        for (int c = 0; c < m; c++) {
            for (int r = 0; r < n; r++) {
                if(!visit[c][r]) {
                    int result = move(m, n, c, r, picture[c][r], visit, picture);
                    if(picture[c][r] != 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, result);
                    }
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int move(int m, int n, int c, int r, int value, boolean[][] visit, int[][] picture) {
        if(!canMove(m, n, c, r, value, visit, picture)) {
            return 0;
        }

        int answer = 1;
        visit[c][r] = true;

        answer += move(m, n, c-1, r, value, visit, picture);
        answer += move(m, n, c+1, r, value, visit, picture);
        answer += move(m, n, c, r-1, value, visit, picture);
        answer += move(m, n, c, r+1, value, visit, picture);

        return answer;
    }


    // c - 행
    // r - 열
    public boolean canMove(int m, int n, int c, int r, int value, boolean[][] visit, int[][] picture) {
        if((0<=c && c < m) && (0<=r && r < n) && !visit[c][r] && value == picture[c][r]) {
            return true;
        }

        return false;
    }
}
