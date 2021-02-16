package programmers.highScoreKit.dfsBfs;

import java.util.*;
import util.GsonUtil;

// 여행경로
public class DfsBfsQ4 {

    public static void main(String[] args) {
//        String[][] tickets = {
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//        };

        String[][] tickets = {
                {"ICN",  "SFO"},{"ICN",  "ATL"},{"SFO",  "ATL"},{"ATL",  "ICN"},{"ATL", "SFO"}
        };

//        String[][] tickets = {
//                {"ICN","A"},{"ICN","B"},{"B","ICN"}
//        };

        // [ICN, JFK, HND, IAD]
        // [ICN, ATL, ICN, SFO, ATL, SFO]
        // [ICN, B, ICN, A]
        GsonUtil.toJsonPrint(solution(tickets));
    }

    public static String[] solution(String[][] tickets) {

        List<Ticket> lTickets = new ArrayList<>();
        for (String[] ticket : tickets) {
            lTickets.add(new Ticket(ticket));
        }

        Collections.sort(lTickets);

        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < lTickets.size(); i++) {
            Ticket ticket = lTickets.get(i);
            if("ICN".equals(ticket.getFrom())) {
                Route route = new Route(lTickets.size());
                boolean[] using = new boolean[lTickets.size()];
                dfs(1, lTickets.size(), ticket, i, lTickets, using, route, routes);
            }
        }

//        GsonUtil.toJsonPrint(routes);

        return routes.get(0).getRoute().toArray(new String[0]);
    }

    public static void dfs(int depth, int length, Ticket ticket, int i, List<Ticket> lTickets, boolean[] using, Route route, List<Route> routes) {
        route.addRoute(depth, ticket);
        if(depth == length) {
            Route tmpRout = new Route();
            tmpRout.getRoute().addAll(route.getRoute());
            routes.add(tmpRout);
            return;
        }

        using[i] = true;

        for (int j = 0; j < lTickets.size(); j++) {
            if(!using[j] && ticket.isNext(lTickets.get(j))) {
                dfs(depth+1, length, lTickets.get(j), j, lTickets, using, route, routes);
            }
        }

        using[i] = false;
    }

    public static class Route {
        private final List<String> route;

        public Route() {
            this.route = new ArrayList<>();
        }

        public Route(int size) {
            this.route = new ArrayList<>();
            this.route.add("ICN");
            for (int i = 0; i < size; i++) {
                this.route.add("");
            }
        }

        public void addRoute(int index, Ticket ticket) {
            this.route.set(index, ticket.getTo());
        }

        public List<String> getRoute() {
            return route;
        }
    }

    public static class Ticket implements Comparable<Ticket> {
        private final String from;
        private final String to;

        public Ticket(String[] ticket) {
            this.from = ticket[0];
            this.to = ticket[1];
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public boolean isNext(Ticket ticket) {
            return this.to.equals(ticket.getFrom());
        }

        @Override
        public int compareTo(Ticket o) {
            if(this.from.equals(o.getFrom())) {
                return this.to.compareTo(o.getTo());
            }

            return this.from.compareTo(o.getFrom());
        }
    }
}
