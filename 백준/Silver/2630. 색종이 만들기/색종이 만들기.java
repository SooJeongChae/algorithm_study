import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
		
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int[] result = divideAndCount(paper, 0, 0, N);
        
        System.out.println(result[0]); // 하얀색 
        System.out.println(result[1]); // 파란색 
	}
    
    // 색종이 쪼개고 개수 셈
    static int[] divideAndCount(int[][] paper, int x, int y, int size) {
        if (isSameColor(paper, x, y, size)) {
            // 모두 같은 색이면 개수 반환
            if (paper[x][y] == 0) {
                return new int[]{1, 0}; // 하얀색
            } else {
                return new int[]{0, 1}; // 파란색
            }
        } else {
            // 색이 섞여 있으면 쪼개기
            int newSize = size / 2;
            int[] result1 = divideAndCount(paper, x, y, newSize); // 1사분면
            int[] result2 = divideAndCount(paper, x, y + newSize, newSize); // 2사분면
            int[] result3 = divideAndCount(paper, x + newSize, y, newSize); // 3사분면
            int[] result4 = divideAndCount(paper, x + newSize, y + newSize, newSize); // 4사분면
            
            // 각각의 결과를 더해서 반환
            return new int[]{
                result1[0] + result2[0] + result3[0] + result4[0], // 하얀색
                result1[1] + result2[1] + result3[1] + result4[1]  // 파란색
            };
        }
    }
    
    // 모두 같은 색인지 확인
    static boolean isSameColor(int[][] paper, int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
