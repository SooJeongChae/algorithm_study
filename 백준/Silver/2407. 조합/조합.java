import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		// m이 n의 절반보다 클 때
		if (n / 2 < m) {
			m = n - m;
		}
		
		// 오버플로우 막기 위해 BigInteger로 변수 생성, ONE(1)으로 세팅
		BigInteger nResult = BigInteger.ONE;
		BigInteger mResult = BigInteger.ONE;
		
		// m이 0보다 클 때 반복
		while (0 < m) {
			nResult = nResult.multiply(BigInteger.valueOf(n));	// multiply로 곱해줌, valueOf로 BigInteger로 변환해서 곱해줘야함
			mResult = mResult.multiply(BigInteger.valueOf(m));
			n--; 
			m--;
		}
		
		System.out.println(nResult.divide(mResult));	// 나누기는 divide
	}
}