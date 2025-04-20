import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 최대 힙 쓰려면 reverseOrder로 써야 함
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            // 0 입력 들어오면 배열에서 가장 큰 값 출력하고 그 값 배열에서 제거
            if (x == 0) {
                // 힙 비어있으면 0 출력
                if (maxHeap.isEmpty()) {
                    System.out.println(0);
                } 
                else {
                    // 있으면 최대값 출력 후 제거
                    System.out.println(maxHeap.poll());
                }
            } 
            else {
                // x 힙에 추가
                maxHeap.add(x);
            }
        }
	}
}