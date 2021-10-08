import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2383 {
	public static int n;
	public static int perCnt;
	public static Stair[] stairs;
	
	public static int[][] map;
	public static Person[] people;
	
	public static int[] pp;
	public static int ans;
	public static class Stair{
		int x;
		int y;
		int time;
		public Stair(int x,int y,int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	public static class Person implements Comparable<Person>{
		int x;
		int y;
		int dis;
		public Person(int x,int y,int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.dis, o.dis);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
		
			n = Integer.parseInt(br.readLine());
			perCnt = 0;
			map = new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) perCnt++;
				}
			}
			stairs = new Stair[2];
			people = new Person[perCnt];
			pp = new int[perCnt];
			ans = 987654321;
			int cnt=0, cnt2=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==1) people[cnt++] = new Person(i,j,0);
					if(map[i][j]>1 && cnt2==0) stairs[cnt2++] = new Stair(i,j,map[i][j]);
					else if(map[i][j]>1 && cnt2==1) stairs[cnt2] = new Stair(i,j,map[i][j]);
				}
			}
			comb(0);
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
	public static void comb(int idx) {
		
		if(idx == perCnt) {
			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();
			
			for(int i=0;i<perCnt;i++) {
				if(pp[i]==0)arr1.add(i);
				else arr2.add(i);
			}
			int tmp = Math.max(cal(arr1,0),cal(arr2,1));
			ans = Math.min(ans,tmp);
			
			return;
		}
		
		comb(idx+1);
		pp[idx]=1;
		comb(idx+1);
		pp[idx]=0;
	}
	public static int cal(ArrayList<Integer> arr,int stairNum) {
	
		int sx = stairs[stairNum].x;
		int sy = stairs[stairNum].y;
		int time = stairs[stairNum].time;
		
		PriorityQueue<Person> pq = new PriorityQueue<>();
		
		LinkedList<Person> q = new LinkedList<>();
		
		for(int i:arr) {
			pq.add(new Person(people[i].x,people[i].y,Math.abs(people[i].x - sx)+ Math.abs(people[i].y - sy)));
			
		}
		int t=0;
		while(!pq.isEmpty()||!q.isEmpty()) {
			int tmpSize = pq.size();
			
			for(int i=0;i<q.size();i++) {
				Person p = q.get(i);
				if(p.dis == time-1) {
					q.pop();
					i--;
				}
				else p.dis++;
			}
			PriorityQueue<Person> pq2 = new PriorityQueue<>();
			for(int i=0;i<tmpSize;i++) {
				Person p = pq.poll();
				if(p.dis==0) {
					if(q.size()==3)
						pq2.add(p);
					
					else 
						q.add(p);
				}
				else {
					p.dis--;
					pq2.add(p);
				}
			}
			pq = pq2;
			t++;
		}
		return t;
	}
	
}
