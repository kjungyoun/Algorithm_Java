import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로 {
	
	static int N,M,cnt;
	static int map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 배열 생성
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		// 입력 저장
		for (int i = 1; i <= N; i++) {
			String line = in.readLine();
			for (int j = 1; j <= M ; j++) {
				map[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		bfs();
		System.out.println(cnt);
	}
	
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 시작점 삽입
		queue.add(new int[] {1,1});
		cnt = 1; // 시작점 카운트
		visited[1][1] = true; // 시작점 방문처리
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			// 같은 거리에 있는 위치들을 탐색
			for (int k = 0; k < size; k++) {
				// 현재 위치를 poll
				int cur[] = queue.poll();
				int r = cur[0];
				int c = cur[1];
				
				// 만약 목적지일 경우 return
				if(r == N && c == M)
					return;
					
				// 4방 탐색
					int nr,nc;
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					
					if(nr>0 && nr<N+1 && nc>0 && nc<M+1 && !visited[nr][nc] && map[nr][nc] == 1) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr,nc});
					}	
				}
			}
			cnt++;
		}
	}
}
