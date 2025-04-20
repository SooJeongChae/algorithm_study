import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            int gold1 = n / 2;
            int gold2 = n / 2;
            
            while (gold1 > 1) {
                if (isPrime(gold1) && isPrime(gold2)) {
                    sb.append(gold1).append(" ").append(gold2).append("\n");
                    break;
                }
                gold1--;
                gold2++;
            }
        }
        
        System.out.print(sb.toString());
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}