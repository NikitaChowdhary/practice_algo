package leetCode;

// https://leetcode.com/problems/find-the-town-judge/
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int judge = -1;
        int[] outgoingEdge = new int[N + 1];
        int[] incomingEdge = new int[N+1];
        for (int[] tr: trust) {
            outgoingEdge[tr[0]]++;
            incomingEdge[tr[1]]++;
        }
        for (int i = 1; i<=N; i++) {
            if (outgoingEdge[i] == 0 && incomingEdge[i] == N - 1)
                judge = i;
        }
        return judge;
    }
}
