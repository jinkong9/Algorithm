import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int people[];
	static boolean[] v;
	static int mindiff = Integer.MAX_VALUE;
	static class Node{
		int idx;
		Node node;
		public Node(int idx, Node node) {
			super();
			this.idx = idx;
			this.node = node;
		}
		
	}
	static Node[] node;
	
	public static boolean bfs(boolean select) { // select로 선택된 구역과 안된 구역을 나눈다. A선거구, B선거구 안써도 되지만 안쓰면 A 선거구의 경우 B 선거구의 경우 따로 구현 해야함.
		boolean visited[] = new boolean[N];
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int start = -1; // 초기 값 주기
		for(int i = 0; i < N; i++) {
			if(v[i] == select) {
				start = i;
				break;
			}
		}
		
		if(start == -1) return false; // 선거구 비어있다.
		
		q.add(start);
		visited[start] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(Node p = node[cur]; p!= null; p = p.node) {
				int next = p.idx;
				if(!visited[next] && v[next] == select) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		
		int total = 0;
		for(int i = 0; i < N; i++) {
			if(v[i] == select) {
				total++;
			}
		}
		return cnt == total;
	}
	
	public static boolean connect() {
		return bfs(true) && bfs(false);
	}
	
	public static void region(int idx, int pickCnt) { // A, B 구역 나누기
		if(idx == N) {
			if(pickCnt == 0 || pickCnt == N) {
				return;
			}
			if(!connect()) {
				return;
			}
			
			int sumA = 0, sumB = 0;
			
			for(int i = 0; i < N; i++) {
				if(v[i]) {
					sumA += people[i];
				} else {
					sumB += people[i];
				}
			}
			mindiff = Math.min(mindiff, Math.abs(sumA - sumB));
			return;
		}
		
		v[idx] = true;
		region(idx+1, pickCnt+1);
		
		v[idx] = false;
		region(idx+1, pickCnt);
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		node = new Node[N];
		people = new int[N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int v = Integer.parseInt(st.nextToken())-1;
				node[i] = new Node(v,node[i]);
				node[v] = new Node(i,node[v]);
			}
		}
		region(0, 0);
		if(mindiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(mindiff);
		}
	}
}
