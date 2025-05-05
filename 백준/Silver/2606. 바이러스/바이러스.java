import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computerCount = Integer.parseInt(br.readLine());
        int connectCount = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computerCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connectCount; i++) {
            String[] input = br.readLine().split(" "); // 오타 수정
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean visited[] = new boolean[computerCount + 1];
    	int virusComputersCount = dfs(1, graph, visited) - 1;
        
        System.out.println(virusComputersCount);
	}

    public static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int connected : graph.get(node)) {
            if (!visited[connected]) {
                count += dfs(connected, graph, visited);
            }
        }

        return count;
    }
}
