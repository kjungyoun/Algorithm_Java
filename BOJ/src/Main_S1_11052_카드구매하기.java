import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_11052_카드구매하기 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int input[] = new int[N+1];
		int dp[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = input[i];
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+dp[j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}