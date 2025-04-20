import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
           char[] arr = br.readLine().toCharArray();
           int count = 0;
           String answer = "NO";
            
           for (int j = 0; j < arr.length; j++) {
               if (arr[j] == '(') {
                   count++;
               } else if (arr [j] == ')') {
                   count--;
               } 
               
               if (count < 0) {
                   break;
               }
           }
            
            if (count == 0) {
                answer = "YES";
            }
            
            System.out.println(answer);
        }
    }
}