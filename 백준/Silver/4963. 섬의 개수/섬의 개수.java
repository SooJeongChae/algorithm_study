import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String whString;
		while (!(whString = br.readLine()).equals("0 0")) {
            String[] wh = whString.split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);
            
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            // 지도 입력 받기
            for (int i = 0; i < h; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int count = 0;

            // 모든 지점에 대해 섬 찾기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(map, visited, i, j, h, w);
                        count++;
                    }
                }
            }

            System.out.println(count);
		}
	}
	
    // DFS 
    private static void dfs(int[][] map, boolean[][] visited, int x, int y, int h, int w) {
        // 방문했으니까 true 저장
        visited[x][y] = true;

        // 방향 배열 (상하좌우, 대각선 총 8방향)
        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        // 탐색
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고, 땅이면서 방문하지 않은 곳
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(map, visited, nx, ny, h, w);
                }
            }
        }
    }
}
