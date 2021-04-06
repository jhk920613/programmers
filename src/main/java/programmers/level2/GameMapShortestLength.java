package programmers.level2;

import util.GsonUtil;
import java.util.*;

// 게임 맵 최단거리
public class GameMapShortestLength {

    public static void main(String[] args) {
        GameMapShortestLength gameMapShortestLength = new GameMapShortestLength();

//        int[][] maps = {
//                {1,1},
//        };
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

//        int[][] maps = {
//                {1,0,1,1,1},
//                {1,0,1,0,1},
//                {1,0,1,1,1},
//                {1,1,1,0,0},
//                {0,0,0,0,1}
//        };

        // 11
        // -1
        GsonUtil.toJsonPrint(gameMapShortestLength.solution(maps));
    }

    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maps[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        LinkedList<Point> queue = new LinkedList<>();
        Point start = new Point(0,0,1);
        queue.add(start);
        move(start, visit);

        while (!queue.isEmpty()) {
            Point point = queue.removeFirst();

            if(point.x == m-1 && point.y == n-1) {
                answer = answer == -1 ? point.distance : Math.min(answer, point.distance);
            }

            if(check(n, m, point.x+1, point.y, maps, visit)) {  //우
                Point new_point = new Point(point.x+1, point.y, point.distance+1);
                queue.add(new_point);
                move(new_point, visit);
            }

            if(check(n, m, point.x-1, point.y, maps, visit)) {   //좌
                Point new_point = new Point(point.x-1, point.y, point.distance+1);
                queue.add(new_point);
                move(new_point, visit);
            }

            if(check(n, m, point.x, point.y+1, maps, visit)) {   //하
                Point new_point = new Point(point.x, point.y+1, point.distance+1);
                queue.add(new_point);
                move(new_point, visit);
            }

            if(check(n, m, point.x, point.y-1, maps, visit)) {   //상
                Point new_point = new Point(point.x, point.y-1, point.distance+1);
                queue.add(new_point);
                move(new_point, visit);
            }

        }

//        answer = bfs(1, n, m, 0, 0, maps, answer);

        return answer;
    }

    public void move(Point point, boolean[][] visit) {
        visit[point.y][point.x] = true;
    }

    public boolean check(int n, int m, int to_x, int to_y, int[][] maps, boolean[][] visit) {

        if(!(0 <= to_x && to_x < m)) {
            return false;
        }

        if(!(0 <= to_y && to_y < n)) {
            return false;
        }

        if(maps[to_y][to_x] == 0) {
            return false;
        }

        if(visit[to_y][to_x]) {
            return false;
        }

        return true;
    }

    public static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
