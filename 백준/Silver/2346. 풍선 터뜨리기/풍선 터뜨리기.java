import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 풍선 개수 int 변환
		String[] strNums = br.readLine().split(" ");	// 풍선 안에 있는 숫자 값
		LinkedList<int[]> nums = new LinkedList<>();	// 숫자 담을 linkedlist
        for (int i = 0; i < n; i++) {
        	nums.add(new int[] {i + 1, Integer.parseInt(strNums[i])});
        }	// String으로 입력받았기 때문에 int형으로 바꾸어서 리스트에 추가해줌
		
        StringBuilder result = new StringBuilder();	// 결과 담음
        int index = 0;
        
        while (nums.size() != 1) {
            int move = nums.get(index)[1];
            int size = nums.size() - 1;

            result.append(nums.get(index)[0]).append(" ");
            nums.remove(index);

            if (move > 0) {
                move--;
            }

            index = (index + move) % size;

            if (index < 0) {
                index += size;
            }

        }

        result.append(nums.get(0)[0]);

        System.out.println(result);
	}
}
