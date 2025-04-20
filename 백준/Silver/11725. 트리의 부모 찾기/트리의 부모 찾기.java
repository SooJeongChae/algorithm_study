import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
        // 트리의 인접 리스트 생성
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 정점 입력 받기
        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        // 부모 노드 저장
        int[] parent = new int[N + 1];
        
        Queue<Integer> queue = new LinkedList<>();	// BFS 탐색
        boolean[] visited = new boolean[N + 1];	// 방문 여부 확인
        
        queue.add(1);	// 루트 노드
        visited[1] = true;	// 방문!
        
        // BFS 
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int child : tree.get(current)) {
                if (!visited[child]) {
                    visited[child] = true;	// 방문 표시
                    parent[child] = current;  // 부모 노드 기록
                    queue.add(child);
                }
            }
        }
        
        // 2번 노드부터 부모 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
	}
}