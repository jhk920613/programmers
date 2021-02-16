package programmers.highScoreKit.dfsBfs;

// 네트워크
public class DfsBfsQ2 {

    public static void main(String[] args) {
//        int n = 3;
//        int[][] computers = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1},
//        };

        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1},
        };

        // 2
        // 1
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int n, int[][] computers, boolean[] visited, int i) {
        if (visited[i]) {    // 방문했으면 이미 다른 네트워크에 속해있는거라 더이상 진행할 필요가 없음
            return;
        }

        visited[i] = true;

        for (int j = 0; j < n; j++) {
            if (i != j && !visited[j] && computers[i][j] == 1) {
                dfs(n, computers, visited, j);
            }
        }
    }
}
