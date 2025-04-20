import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] weathers = new int[n];
		for (int i = 0; i < n; i++) {
			weathers[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n - k + 1; i++) {
			int tmp = 0;
			for (int j = i; j < i + k; j++) {
				tmp += weathers[j];
			}
			if (tmp > max) {
				max = tmp;
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}
}
