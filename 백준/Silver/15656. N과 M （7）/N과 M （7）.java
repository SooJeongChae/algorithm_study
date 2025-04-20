import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        String[] numStr = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        
        Arrays.sort(nums); // 오름차순 정렬
        int[] picked = new int[m];
        StringBuilder sb = new StringBuilder();
        pick(0, nums, picked, sb);
        
        System.out.print(sb.toString());
    }
    
    static void pick(int count, int[] nums, int[] picked, StringBuilder sb) {
        if (count == picked.length) {
            for (int i = 0; i < picked.length; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            picked[count] = nums[i];
            pick(count + 1, nums, picked, sb);
        }
    }
}