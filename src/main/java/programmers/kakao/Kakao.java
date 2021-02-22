package programmers.kakao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kakao {

    public static void main(String[] args) {


        String[] lines = new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s",
        };
        Long[][] listLines = new Long[lines.length][2];

        List<Long> points = new ArrayList<Long>();

        for (int i = 0; i < lines.length; i++) {
            listLines[i] = returnSec(lines[i]);
            points.add(listLines[i][0]);
            points.add(listLines[i][1]);
        }

        Collections.sort(points);
        int answer = 0;
        for (int i = 0; i < points.size(); i++) {
            Long point = points.get(i);
            int tmpAnswer = 0;
            for (int l = 0; l < listLines.length; l++) {
                Long[] line = listLines[l];

                if(isInRange(point, point + 999, line)) {
                    tmpAnswer++;
                }

                if(answer < tmpAnswer) {
                    answer = tmpAnswer;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isInRange(Long pointS, Long pointE, Long[] line) {

        if(line[1] < pointS || line[0] > pointE) {
            return false;
        } else {
            return true;
        }

    }

    public static Long[] returnSec(String time) {
        String[] tmp = time.split(" ");

        String hms = tmp[1];
        String intervalS = tmp[2].substring(0, tmp[2].length() - 1);

        Long endTime = Timestamp.valueOf(tmp[0] + " " + tmp[1]).getTime();

        Long startTime = endTime - ((long) Double.parseDouble(intervalS) * 1000) + 1;
        System.out.print(startTime);
        System.out.print(" / ");
        System.out.println(endTime);

        return new Long[] { startTime, endTime };
    }

}