import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_G4_6137_문자열생성 {
	static LinkedList<Character> list;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char T[] = new char[N];
		
		list = new LinkedList<Character>();
		
		// 입력을 받음
		for (int i = 0; i < N; i++) {
			list.add(in.readLine().charAt(0));
		}
		
		
		for (int i = 0; i<N; i++) {
			int size = list.size();
			
			boolean result = find(0,size-1);
			
			if(result) {
				T[i] = list.pollFirst();
			}else {
				T[i] = list.pollLast();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(T[i-1]);
			if(i != 0 && i%80 == 0)
				System.out.print("\n");
		}
	}
	
	public static boolean find(int firstIdx, int lastIdx) {
		if(firstIdx == lastIdx) return true; // 서로 같은 문자를 가리킬 때 나가기
		
		char first = list.get(firstIdx);
		char last = list.get(lastIdx);
		
		if(first < last)
			return true;
		else if(first > last)
			return false;
		else {
			if(firstIdx+1 >= lastIdx-1) return true;
			return find(firstIdx+1, lastIdx-1);
		}
	}

}
