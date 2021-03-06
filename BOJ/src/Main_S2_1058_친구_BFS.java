import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S2_1058_친구_BFS {
	static int N,max;
	static char adjMatrix[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람의 수
		N = Integer.parseInt(in.readLine());
		adjMatrix = new char[N][N];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
		
		System.out.println(max);
	}
	
	
	public static void bfs(int cur) {
		Queue<Integer>queue = new LinkedList<Integer>();
		
		boolean visited[] = new boolean[N];
		visited[cur] = true;
		int cnt = 0;
		
		// 내 친구들 count
		for (int i = 0; i < N; i++) {
			if(adjMatrix[cur][i] == 'Y') {
				queue.add(i);
				visited[i] = true;
				cnt++;
			}
		}
		
		// 친구의 친구 수 구하기
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int friend = queue.poll();
			for (int j = 0; j < N; j++) {
				// 내 친구의 친구가 내 친구가 아니면 count
				if(adjMatrix[friend][j] == 'Y' && !visited[j]) {
					cnt++;
					visited[j] = true;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}
}
