package GFGeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dependencies {
    public static void main (String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int inputs = Integer.parseInt(in.readLine());
        while(inputs != 0) {
            String[] nodes = in.readLine().split(" ");
            int node = Integer.parseInt(nodes[0]);
            int edge = Integer.parseInt(nodes[1]);
            String input = in.readLine();
            System.out.println(edge);
            inputs--;
        }


        //code
    }
}
