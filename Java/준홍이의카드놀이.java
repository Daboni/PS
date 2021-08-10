import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 준홍이의카드놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					int val = 0;
					if(hm.containsKey(i+j)) {
						val = hm.get(i+j);
					}
					hm.put(i+j,++val);
				}
			}
			int max=-1;
			ArrayList<Integer> arr = new ArrayList<>();
			for(Entry<Integer,Integer> e: hm.entrySet()) {
				if(e.getValue()>max) {
					max = e.getValue();
					arr.clear();
					arr.add(e.getKey());
				}
				else if(e.getValue()==max) arr.add(e.getKey());
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			for(int x:arr) {
				sb.append(x+" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
	}
}
