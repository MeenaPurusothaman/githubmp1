import java.util.*;

 class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(v);
            int shortestPath = bfs(graph, n);
            result[i] = shortestPath;
        }
        
        return result;
    }
    private int bfs(List<List<Integer>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int neighbor : graph.get(city)) {
                if (dist[neighbor] == -1) {  
                    dist[neighbor] = dist[city] + 1;
                   queue.offer(neighbor);
                }
            }
        }
        return dist[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        int[][] queries = {{0, 2}, {2, 4}, {1, 3}};
        
        int[] result = sol.shortestDistanceAfterQueries(n, queries);
        System.out.println(Arrays.toString(result));
    }
}

            

        
         
    