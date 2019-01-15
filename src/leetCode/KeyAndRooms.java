package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KeyAndRooms {



    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> roomPattern = new HashMap<>();
        for (int i =0; i< rooms.size(); i++) {
            roomPattern.put(i, rooms.get(i));
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        dfs(0, roomPattern, visited);
        return (visited.size() == rooms.size());
    }

    private void dfs(int start, Map<Integer, List<Integer>> roomPattern, Map<Integer, Boolean> visited) {
        visited.put(start, true);
        for (int adj: roomPattern.getOrDefault(start, new LinkedList<>())) {
            if (!visited.containsKey(adj))
                dfs(adj, roomPattern, visited);
        }
    }

    //************************************************************************************************************
    // Optimized code

    private boolean canVisitAllRooms1(List<List<Integer>> rooms) {

        Map<Integer, Boolean> visited = new HashMap<>();
        dfsUpdated(0, rooms, visited);
        return (visited.size() == rooms.size());
    }

    private void dfsUpdated(int start, List<List<Integer>> rooms, Map<Integer, Boolean> visited) {
        visited.put(start, true);
        for (int adj: rooms.get(start)) {
            if (!visited.containsKey(adj))
                dfsUpdated(adj, rooms, visited);
        }
    }


//    private static List<Integer> stringToIntegerList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        List<Integer> arr = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            arr.add(jsonArray.get(i).asInt());
//        }
//        return arr;
//    }
//
//    public static List<List<Integer>> stringToInt2dList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToIntegerList(cols.toString()));
//        }
//        return list;
//    }
//
//    public static String booleanToString(boolean input) {
//        return input ? "True" : "False";
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> keys = new LinkedList<>();
        keys.add(1);
        keys.add(3);
        rooms.add(keys);

        keys = new LinkedList<>();
        keys.add(3);
        keys.add(0);
        keys.add(1);
        rooms.add(keys);

        keys = new LinkedList<>();
        keys.add(2);
        rooms.add(keys);

        keys = new LinkedList<>();
        keys.add(0);
        rooms.add(keys);

        boolean ret = new KeyAndRooms().canVisitAllRooms1(rooms);
        System.out.println(ret);


//        while ((line = in.readLine()) != null) {
//            List<List<Integer>> rooms = stringToInt2dList(line);
//
//            boolean ret = new KeyAndRooms().canVisitAllRooms(rooms);
//
//            String out = booleanToString(ret);
//
//            System.out.print(out);
//        }
    }
}
