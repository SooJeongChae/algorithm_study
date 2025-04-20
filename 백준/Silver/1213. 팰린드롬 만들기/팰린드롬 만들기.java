import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine();
		char[] strName = name.toCharArray();
		Arrays.sort(strName);	// 일단 오름차순 정렬..
		
		int[] charCount = new int[26];	// 문자별 개수 세서 저장
        for (char c : strName) {
            charCount[c - 'A']++;
        }	// 해당 문자 나올 때마다 문자에 해당하는 인덱스 1씩 더해주기
		
        int oddCount = 0;	// 홀수 개수 세서 저장
        char middleChar = 0;	// 홀수 문자
        for (int i = 0; i < 26; i++) {
        	// 문자가 홀수일 때
            if (charCount[i] % 2 != 0) {
                oddCount++;	// 홀수 count에 더해줌 
                middleChar = (char) (i + 'A');	// 홀수 문자는 무조건 가운데!!!에 하나는 꼭 넣어줘야하니까 따로 저장
            }
            
            // 홀수 개수가 1 초과하면 팰린드롬 안 되니까 문장 출력하고 종료
            if (oddCount > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        
        StringBuilder half = new StringBuilder();	// 팰린드롬 반쪽
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charCount[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }
        
        StringBuilder result = new StringBuilder();	// 출력할 결과 저장
        result.append(half); // 앞부분
        if (middleChar != 0) {
            result.append(middleChar); // 중간 문자
        }
        result.append(half.reverse()); // 뒷부분
        
        System.out.println(result.toString());
    }
}
