import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1197_최소스패닝트리_Kruskal {
	
	static int parents[], V, E, rank[];
	static Edge edgeList[];
	
	static class Edge implements Comparable<Edge>{
		
		int to,from,weights;

		public Edge(int from, int to, int weights) {
			super();
			this.from = from;
			this.to = to;
			this.weights = weights;
		}



		@Override
		public int compareTo(Edge o) {
			// 가중치 기준으로 오름차순 정렬
			return Integer.compare(this.weights, o.weights);
		}
		
	}
	
	public static void make() {
		// 서로소 집합 초기화 과정
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == a) return a;
		
		// path Compression 진행
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		// cycle 생성되었을 때
		if(rootA == rootB) return false;
		else {
			
			// rank 배열로 compression 진행
			if(rank[rootA] > rank[rootB]) {
				parents[rootB] = rootA;
			}else {
				parents[rootA] = rootB;
				if(rank[rootA] == rank[rootB])
					rank[rootB]++;
			}
			return true;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		rank = new int[V+1];
		make();
		edgeList = new Edge[E];
		
		// 간선 리스트 생성
		for (int i = 0; i < E ; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weights = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to, weights);
		}
		
		
		int result = 0;
		// 가중치 기준으로 오름차순 정렬
		Arrays.sort(edgeList);
		int count = 0;
		
		// 간선 선택과정
		for (int i = 0; i < E; i++) {
			Edge cur = edgeList[i];
			if(union(cur.from, cur.to)) {
				result += cur.weights;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
