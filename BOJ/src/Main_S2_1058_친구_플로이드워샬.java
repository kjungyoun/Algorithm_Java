import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S2_1058_친구_플로이드워샬 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		char adjMatrix[][] = new  char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = line.charAt(j);
			}
		}
		
		
	}

}
