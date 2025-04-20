import java.util.Arrays;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();	// 전체 숫자 개수
		int m = sc.nextInt();	// 뽑을 숫자 개수
		
		int[] nums = new int[n];	// 입력 받는 int 배열
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		int[] picked = new int[m];	// 결과 담을 배열
		pick(n, m, m, nums, picked);	
		
		sc.close();
	}
	
	// n개의 숫자 중에서 m개를 뽑아 출력
	static void pick(int n, int m, int toPick, int[] nums, int[] picked) {
		int lastIndex = m - toPick - 1;
		int smallest;
		if (m == toPick)
			smallest = 0;
		else
			smallest = picked[lastIndex];
		
		if (toPick == 0) {
			for (int num: picked) {
				System.out.print(nums[num] + " ");
			}
			System.out.println();
			
			return;
		}
		else {
			for (int i = smallest; i < n; i++) {
				picked[lastIndex + 1] = i;
				pick(n, m, toPick - 1, nums, picked);
			}
		}
	}
}
