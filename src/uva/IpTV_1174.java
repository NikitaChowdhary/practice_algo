package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class IpTV_1174 {
    // javac uva/IpTV_1174.java
    // java -cp . uva.IpTV_1174 < uva/resources/IPTV.txt > output.txt
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());

        while(cases-- != 0) {
            in.readLine();
            int cities = Integer.parseInt(in.readLine());
            Map<String, List<ConnectionCost>> network = getNetwork(in);
            Map<String, ConnectionCost> queuMapping = new HashMap<>();
            PriorityQueue<ConnectionCost> queue = getQueue(queuMapping, network);

            System.out.println(getMinCost(queue, queuMapping, network));
            if (cases != 0)
                System.out.println();

        }
    }

    private static int getMinCost(PriorityQueue<ConnectionCost> queue,
                                  Map<String, ConnectionCost> queueMapping,
                                  Map<String, List<ConnectionCost>> network) {
        int cost = 0;
        while(!queue.isEmpty()) {
            ConnectionCost current = queue.poll();
            queueMapping.remove(current.city);
            cost+= current.cost;

            for (ConnectionCost adj: network.getOrDefault(current.city, new ArrayList<>())) {
                if (queueMapping.containsKey(adj.city)) {
                    ConnectionCost queueValue = queueMapping.get(adj.city);
                    if (queueValue.cost > adj.cost) {
                        queueMapping.put(adj.city, adj);
                        queue.remove(queueValue);
                        queue.add(adj);
                    }
                }
            }
        }

        return cost;
    }

    private static PriorityQueue<ConnectionCost> getQueue(Map<String, ConnectionCost> queuMapping, Map<String, List<ConnectionCost>> network) {
        Comparator<ConnectionCost> comp = new Comparator<ConnectionCost>() {
            @Override
            public int compare(ConnectionCost o1, ConnectionCost o2) {
                if (o1.cost < o2.cost) return -1;
                else if (o1.cost == o2.cost) return 0;
                else return 1;
            }
        };
        PriorityQueue<ConnectionCost> queue = new PriorityQueue<>(comp);
        int cost = 0;
        for (String city: network.keySet()) {
            ConnectionCost connectionCost = new ConnectionCost(city, cost);
            cost = Integer.MAX_VALUE;
            queuMapping.put(city, connectionCost);
            queue.add(connectionCost);
        }
        return queue;
    }

    private static Map<String, List<ConnectionCost>> getNetwork(BufferedReader in) throws IOException {
        int connections = Integer.parseInt(in.readLine());
        Map<String, List<ConnectionCost>> network = new HashMap<>();
        for (int i = 0; i< connections; i++) {
            String[] input = in.readLine().split(" ");

            String c1 = input[0];
            String c2 = input[1];
            int cost = Integer.parseInt(input[2]);

            List<ConnectionCost> adjacent = network.getOrDefault(c1, new ArrayList<>());
            adjacent.add(new ConnectionCost(c2, cost));
            network.put(c1, adjacent);

            adjacent = network.getOrDefault(c2, new ArrayList<>());
            adjacent.add(new ConnectionCost(c1, cost));
            network.put(c2, adjacent);
        }
        return network;
    }

    static class ConnectionCost {
        String city;
        int cost;
        ConnectionCost(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
