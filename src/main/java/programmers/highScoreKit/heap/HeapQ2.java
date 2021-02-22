package programmers.highScoreKit.heap;

import util.GsonUtil;

import java.util.*;

// 디스크 컨트롤러
public class HeapQ2 {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        // 9
        System.out.println(GsonUtil.toJson(solution(jobs)));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        // 대기 우선순위 큐는 작업시간이 짧은 순으로 정렬
        PriorityQueue<int[]> waitQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        waitQ.addAll(Arrays.asList(jobs));

        // 작업 우선순위 큐는 요청시간이 빠른 순으로 정렬
        PriorityQueue<int[]> workQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 대기 우선순위에서 뽑았을 때 작업 우선순위 큐에 들어갈 수 없는 job 들이 일시저장될 리스트
        List<int[]> storeList = new ArrayList<>();

        int time = -1; // 현재시간
        while (true) {
            time++; // 시간 증가

            while (!waitQ.isEmpty()) {  // 대기 큐가 일단 빌 떄까지 작업 큐 대상 찾기 반복
                int[] job = waitQ.poll();
                if(checkPossible(time, workQ, job)) {   // 현재 가능한 작업이라면 작업 큐에 추가
                    workQ.add(job);
                } else {
                    storeList.add(job); // 그 외에는 작업 불가능 임시 저장 리스트에 추가
                }
            }

            if(!workQ.isEmpty()) { // 현재 시간에 가능한 작업이 있다면
                int[] nowJob = workQ.poll();    // 작업 큐의 첫번째 값을 뽑아낸다 (요청시간이 가장 빠르면서 작업시간이 짧은 작업이기 때문에)
                answer += getDuration(time, nowJob);
                time = endTime(time, nowJob);
                waitQ.addAll(workQ);    // 작업 큐에 남아있는 나머지 작업들을 다시 대기 큐에 옮기고 클리어
                workQ.clear();
            }
            waitQ.addAll(storeList);    // 임시 저장 리스트에 있는 작업을 전부 대기 큐에 옮기고 클리어
            storeList.clear();

            // 위 작업을 마쳤을 때 더이상 대기하는 작업이 없거나 현재 시간이 1000초 라면 정지
            if(waitQ.size() == 0) {
                break;
            } else if(time == 1000) {
                break;
            }
        }

        return answer / jobs.length;
    }

    public static int endTime(int time, int[] nowJob) {
        // 작업이 종료된 시점에서 바로 다음 작업을 확인해야하기 때문에 1초를 빼준다.
        return time + nowJob[1] - 1;
    }

    public static int getDuration(int time, int[] nowJob) {
//        System.out.println(time + "초");
//        GsonUtil.toJsonPrint(nowJob);
        if(nowJob[0] < time) {
//            GsonUtil.toJsonPrint(time - nowJob[0] + nowJob[1]);
            return time - nowJob[0] + nowJob[1];
        } else {
//            GsonUtil.toJsonPrint(nowJob[1]);
            return nowJob[1];
        }
    }

    public static boolean checkPossible(int time, PriorityQueue<int[]> workQ, int[] job) {
        // 작업 큐가 비어잊지 않을 때는 새로 추가될 작업이 무조건 작업 큐의 첫 번째 작업의 작업시간보다 작거나 같으면서
        // 작업 가능한 시간일 때만 추가
        // 그 외는 현재 작업할 대상이 아님 (현재 작업 가능한 시간이 아니거나, 작업 가능하지만 작업 큐에 있는 작업들보다 작업시간이 길다는 의미)
        if(!workQ.isEmpty()) {
            return job[0] <= time && job[1] <= workQ.peek()[1];
        }
        return job[0] <= time;
    }

}
