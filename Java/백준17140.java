import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
	int num;
	int cnt;
	
	Pair(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	public int compareTo(Pair that) {
		if(this.cnt < that.cnt) {
			return -1;
		}
		else if(this.cnt == that.cnt) {
			if(this.num <that.num) {
				return -1;
			}
			else if(this.num == that.num) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
}
public class 백준17140 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<3;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int row = 3;
		int col = 3;
		if(a[r][c]==k) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int t=1;t<=100;t++) {
			if(col>=row) {
				int new_row = row;
				for(int i=0;i<col;i++) {
					HashMap<Integer, Integer> d = new HashMap<>();
					for(int j=0;j<row;j++) {
						if(a[i][j] == 0) continue;
						int val=0;
						if(d.containsKey(a[i][j])) {
							val=d.get(a[i][j]);
						}
						val++;
						d.put(a[i][j], val);
					}
					ArrayList<Pair> v = new ArrayList<>();
					for(Entry<Integer,Integer> e : d.entrySet()) {
						v.add(new Pair(e.getKey(),e.getValue()));
					}
					Collections.sort(v);
					int l = Math.min((int)v.size(), 50);
					for(int j=0;j<l;j++) {
						a[i][j*2] = v.get(j).num;
						a[i][j*2+1] = v.get(j).cnt;
					}
					for(int j=l*2;j<100;j++) {
						a[i][j]=0;
					}
					if (new_row < (int)v.size()*2){
						new_row = (int)v.size()*2;
					}
				}
				row=new_row;
			}else {
				int new_col = col;
                for (int j=0; j<row; j++) {
                    HashMap<Integer, Integer> d = new HashMap<>();
                    for (int i=0; i<col; i++) {
                        if (a[i][j] == 0) continue;
                        int val = 0;
                        if (d.containsKey(a[i][j])) {
                            val = d.get(a[i][j]);
                        }
                        val += 1;
                        d.put(a[i][j], val);
                    }
                    ArrayList<Pair> v = new ArrayList<>();
                    for (Entry<Integer, Integer> e : d.entrySet()) {
                        v.add(new Pair(e.getKey(), e.getValue()));
                    }
                    Collections.sort(v);
                    int l = Math.min((int)v.size(), 50);
                    for (int i=0; i<l; i++) {
                        a[i*2][j] = v.get(i).num;
                        a[i*2+1][j] = v.get(i).cnt;
                    }
                    for (int i=l*2; i<100; i++) {
                        a[i][j] = 0;
                    }
                    if (new_col < (int)v.size()*2) {
                        new_col = (int)v.size()*2;
                    }
                }
                col = new_col;
			}
			if (a[r][c] == k) {
	                System.out.println(t);
	                System.exit(0);
	        }
			
		}
		System.out.println(-1);
	}
}
