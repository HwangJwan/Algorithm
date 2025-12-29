package A3BFS;

import java.util.*;

public class A02BFS최단거리 {
    static boolean[] visited;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}};
        adjList=new ArrayList<>();
        visited=new boolean[nodes.length];
//        0부터 target까지 가는 최단거리
        for(int i=0;i< 5;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] a:nodes) {
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        for(List<Integer> a:adjList) {
            a.sort(Comparator.naturalOrder());
        }
        int target=4;
        Queue<int[]> myQue=new LinkedList<>();
        myQue.add(new int[]{0,0});   // int 배열 안에는 {노드번호, 거리}
//        int[] distance=new int[5];
//        리스트에 Integer만 넣고 따로 거리만 저장하는 배열을 두는 것도 가능 각 노드에 따른 거리는 distance[a]=distance[cur]+1;
        visited[0]=true;
        int answer=-1;
        loop:
        while(!myQue.isEmpty()) {
            int[] cur=myQue.poll();
            if(cur[0]==target) {
                answer=cur[1];
                break;
            }
            for(int a:adjList.get(cur[0])) {
                if(visited[a]) continue;
                myQue.add(new int[]{a,cur[1]+1});
                visited[a]=true;
                if(target==a) {
                    answer=cur[1]+1;
                    break loop;
                }
            }
        }
        System.out.println(answer);
    }
}
