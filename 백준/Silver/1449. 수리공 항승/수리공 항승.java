import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NL = br.readLine().split(" ");
        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);
        
        String[] strLeak = br.readLine().split(" ");
        int[] leak = new int[N];
        for (int i = 0; i < N; i++) {
        	leak[i] = Integer.parseInt(strLeak[i]);
        }
        Arrays.sort(leak);	// 물 새는 곳 오름차순 정렬
        
        int count = 0;	// 테이프 개수 저장
        int fixed = 0;	// 어디까지 고쳤는지 저장
        for (int i = 0; i < N; i++) {
        	// 아직 덜 고친 부분일 떄
        	if (leak[i] > fixed) {
        		count++;	// 테이프 하나 더 씀
        		fixed = leak[i] + L - 1;	// 고친 부분 표시, 0.5씩 여유 두면 1 빼야 함
        	}
        }
        
        System.out.println(count);
	}
}