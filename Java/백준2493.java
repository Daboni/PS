import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pair{
	
	int idx;
	int hi;
	
	Pair(int x, int y){
		this.idx = x;
		this.hi = y;
	}
}

public class 백준2493 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
	
		LinkedList<Pair> dq = new LinkedList<Pair>();
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		Pair p = new Pair(0,Integer.parseInt(st.nextToken()));
		dq.push(p);
		
		StringBuilder sb = new StringBuilder();
		sb.append("0 ");
		for(int i=1;i<n;i++) {
			int cur = Integer.parseInt(st.nextToken());
			
			p = new Pair(i,cur);
			
			while(true) {
				if(dq.isEmpty()) {
					sb.append("0 ");
					dq.push(p);
					break;
				}
				Pair max = dq.peek();
				if(max.hi>p.hi) {
					sb.append(max.idx+1+" ");
					dq.push(p);
					break;
				}
				else {
					dq.pop();
				}
			}

		}
		out.write(sb.toString()+"\n");
		out.flush();
	}
}
