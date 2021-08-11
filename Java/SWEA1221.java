import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


class Pair2 implements Comparable<Pair2>{
	public int x;
	public String s;
	
	Pair2(int x, String s){
		this.x = x;
		this.s = s;
	}
	
	@Override
	public int compareTo(Pair2 that) {
		
		return this.x-that.x;
	}
	
}

public class SWEA1221 {
	
	public static Map<String, Integer> map = new HashMap<>();
//	public static String[] m = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int T = sc.nextInt();
		map.put("ZRO",0);
		map.put("ONE",1);
		map.put("TWO",2);
		map.put("THR",3);
		map.put("FOR",4);
		map.put("FIV",5);
		map.put("SIX",6);
		map.put("SVN",7);
		map.put("EGT",8);
		map.put("NIN",9);
		

		for(int tc=1;tc<=T;tc++) {
			StringBuilder st = new StringBuilder();
			
			st.append(sc.next()+" ");
			int n = sc.nextInt();
//			Pair2[] ps = new Pair2[n];
			ArrayList<Pair2> ps = new ArrayList<Pair2>();
			for(int i=0;i<n;i++) {
				String s = sc.next();
				ps.add(new Pair2(map.get(s),s));
			}
			Collections.sort(ps);
			for(int i=0;i<n;i++) {
				st.append(ps.get(i).s+" ");
			}
			System.out.println(st.toString());
		}
	}
}
