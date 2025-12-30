package A2DFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A01DFS방문순서 {
    static boolean[] visited;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
//        출발은 0부터 시작했을때 dfs로 방문할 경우 방문 순서
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}};
        adjList=new ArrayList<>();
        visited=new boolean[nodes.length];
        for(int i=0;i< 5;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] a:nodes) {
//            양방향 간선인 경우
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
//        정점 번호가 작은 것부터 방문하기 위한 정렬작업
        for(List<Integer> a:adjList) {
            a.sort(Comparator.naturalOrder());
        }
        dfs(0);
    }
    static void dfs(int start) {
        System.out.println(start);
        visited[start]=true;
        for(int target:adjList.get(start)) {
            if(visited[target]) continue;
            dfs(target);
        }
    }
}
