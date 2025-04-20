import java.util.Arrays;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 숫자 개수
		int m = sc.nextInt();	// 선택할 숫자 개수
		int[] nums = new int[n];	// n개의 숫자 입력받을 배열
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}	
		
		Arrays.sort(nums);	// 숫자 오름차순 정렬
		int[] pick = new int[m];	// m개 숫자 뽑아서 담아놓을 배열
		dfs(0, 0, nums, pick);	// start index 0, picked(뽑은 개수) 0, nums배열, 뽑아서 담을 배열 pick
		
		sc.close();
	}
	
	static void dfs(int start, int picked, int[] n, int[] p) {
		// 뽑은 개수랑 p.length(배열 크기, 뽑을 개수)랑 같으면 출력 후 return
		if (picked == p.length) {
			for (int num : p) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n.length; i++) {
			p[picked] = n[i];
			dfs(i + 1, picked + 1, n, p);
		}
	}
}