import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = X.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : X) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
