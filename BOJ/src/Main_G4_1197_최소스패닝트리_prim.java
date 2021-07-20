import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1197_최소스패닝트리_prim {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int adjMatrix[][] = new int[V][V];
		int minEdge[] = new int[V];
		boolean visited[] = new boolean[V];
		
		// minEdge 초기화
		for (int i = 0; i < V; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weights = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = weights;
		}
		
		// 시작 정점 초기화
		minEdge[0] = 0;
		int result = 0;
		
		for (int c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			// 가장 가중치가 작은 간선 선택
			for (int i = 0; i < V; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 간선 선택
			result += min;
			visited[minVertex] = true;
			
			// minEdge 값 update
			for (int i = 0; i < V; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i]> adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}

}
