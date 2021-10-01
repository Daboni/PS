import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준17472 {
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int n;
	public static int m;
	
	public static int[][] map;
	public static int landNo;
	
	public static ArrayList<HashMap<Integer,Integer>> edgeList;
	public static ArrayList<ArrayList<Node>> graph;
	
	public static class Node implements Comparable<Node>{
		int d;
		int dis;
		
		public Node(int d,int dis) {
			this.d=d;
			this.dis=dis;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dis,o.dis);
		}

	}
	
	static boolean[] visit;
	static PriorityQueue<Node> pq;
	
	static int ans;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		
		edgeList = new ArrayList<>();
		for(int i=0;i<=-landNo;i++) {
			edgeList.add(new HashMap<Integer,Integer>());
		}
		makeEdge();
		
		graph = new ArrayList<>();
		for (int i = 0; i <= -landNo; i++) { 
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<edgeList.size();i++) {
			
			for(Map.Entry<Integer, Integer> entry : edgeList.get(i).entrySet()) {
				graph.get(i).add(new Node(entry.getKey(), entry.getValue()));
			}
			
		}
		
		visit = new boolean[(-landNo)+1];
		pq = new PriorityQueue<>();
		
		pq.add(new Node(1,0));
		
		while (!pq.isEmpty()) {
			Node edge = pq.poll();
			if(visit[edge.d]) continue; 
			visit[edge.d] = true;
			ans += edge.dis;
			for (Node next : graph.get(edge.d)) {
				if(!visit[next.d]) { 
					pq.add(next);
					}
				}
			if (++count > -landNo) break; 
		}
		for(int i=1;i<visit.length;i++) {
			if(!visit[i]) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans==0?-1:ans);

	}
	public static void bfs(int sx,int sy) {
		
		landNo -= 1;
		
		Queue<int[]> q = new LinkedList<>();
		map[sx][sy]=landNo;
		q.add(new int[] {sx,sy});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				while(isRange(nx,ny) && map[nx][ny] ==1) {
					
					q.add(new int[] {nx,ny});
					map[nx][ny] = landNo;
					
				}
			}
		}
		
	}
	public static boolean isRange(int nx,int ny) {
		if(nx<0 || nx>=n || ny <0 || ny >=m) return false;
		return true;
	}
	
	public static void makeEdge() {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0) {
					
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						int cnt = 0;
						while(true) {
							
							if(!isRange(nx,ny)) {
								cnt = 0;
								break;
							}
							if(map[nx][ny]==map[i][j]) {
								cnt = 0;
								break;
							}
							if(map[nx][ny]!=0) {
								break;
							}
							cnt++;
							nx += dx[k];
							ny += dy[k];
						}
						if(cnt>1) {
							if(edgeList.get(-map[i][j]).containsKey(-map[nx][ny])) {
								cnt = Math.min(edgeList.get(-map[i][j]).get(-map[nx][ny]),cnt);
								edgeList.get(-map[i][j]).put(-map[nx][ny], cnt);
							}
							else edgeList.get(-map[i][j]).put(-map[nx][ny], cnt);
						}
					}
					
					
				}
			}
		}
		
	}
}
