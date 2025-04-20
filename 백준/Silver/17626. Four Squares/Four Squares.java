import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
        int[] dp = new int[n + 1];
        for(int i = 1; i * i <= n; i++) {
            dp[i*i] = 1;
        }
        for(int i = 1; i <= n; i++) {
            if(dp[i] == 1)
                continue;
            
            int min=Integer.MAX_VALUE;
            
            for(int j = 1; j * j <= i / 2; j++) {
                min = Integer.min(min, dp[j * j] + dp[i - j * j]);
            }
            dp[i] = min;
        }
        
        System.out.println(dp[n]);
	}
}
