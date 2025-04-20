import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 동생 수
        int S = Integer.parseInt(st.nextToken());  // 수빈 위치

        st = new StringTokenizer(br.readLine());
        int[] distance = new int[N];  // 동생들과의 거리
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > S) {
                distance[i] = tmp - S;
            } else {
                distance[i] = S - tmp;
            }
        }
        Arrays.sort(distance);  // 정렬

        int answer = getGCD(distance);
        System.out.println(answer);
    }

    static int getGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}