import java.util.Arrays;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 수열 크기 n
		int[] nums = new int[n];	// n 크기의 int 배열
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int x = sc.nextInt();	// 자연수 x
		
		Arrays.sort(nums);	// 배열 오름차순 정렬
		
		int count = 0;	// 결과 저장 변수
		for (int i = 0; i < n; i++) {
			// nums[i]가 x보다 크다면 for문 탈출
			if (nums[i] >= x) {
				break;
			}
			
			// 바로 뒤에 거부터 더해보자..
			for (int j = i + 1; j < n; j++) {
				// nums[i] + nums[j]가 x면 count 더해주고 탈출
				if (nums[i] + nums[j] == x) {
					count++;
					break;
				}
				// nums[i] + nums[j]가 x보다 크면 그냥 나가자
				else if (nums[i] + nums[j] > x) {
					break;
				}
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
