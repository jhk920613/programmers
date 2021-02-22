package programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kakao2 {

    public static void main(String[] args) {

        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        List<Duration> durations = new ArrayList<Duration>();
        List<Double> points = new ArrayList<Double>();

        for (String line : lines) {
            Duration duration = new Duration(line);
            durations.add(duration);
            points.add(duration.getStart());
            points.add(duration.getEnd());
        }

        Collections.sort(points);

        int max = 0;
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            Double point = points.get(i);
            sum = 0;
            for (int j = 0; j < durations.size(); j++) {
                if(durations.get(j).isIn(point, (point * 1000 + 999) / 1000)) {
                   sum++;
                }
            }

            if(sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }

    static class Duration {

        private Double start;
        private Double end;

        public Duration(String line) {
            String[] split = line.split(" ");

            String[] hhmmss = split[1].substring(0, 8).split(":");
            Double hh = Double.parseDouble(hhmmss[0]) * 60 * 60;
            Double mm = Double.parseDouble(hhmmss[1]) * 60;
            Double ss = Double.parseDouble(hhmmss[2]);
            Double sss = Double.parseDouble("0." + split[1].substring(9));

//            System.out.println(hh);
//            System.out.println(mm);
//            System.out.println(ss);
//            System.out.println(sss);

//            System.out.println(" = " + (hh + mm + ss + sss));

            Double interval = Double.parseDouble(split[2].substring(0, split[2].length() - 1));
//            System.out.println(interval);

            this.setEnd(hh + mm + ss + sss);
            this.setStart((this.getEnd() * 1000 - (interval * 1000 - 1)) / 1000);
        }

        public boolean isIn(Double pointS, Double pointE) {

            if(this.end < pointS || pointE < this.start) {
                return false;
            } else {
                return true;
            }

        }

        public Double getStart() {
            return this.start;
        }

        public Double getEnd() {
            return this.end;
        }

        public void setStart(Double start) {
            this.start = start;
        }

        public void setEnd(Double end) {
            this.end = end;
        }

    }


}
