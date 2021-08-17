
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정 {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			
			int val = this.end - o.end;
			if(val !=0) return val;
			
			return this.start-o.start;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] meetings = new Meeting[N];
		for(int i=0;i<N;i++) {
			meetings[i] = new Meeting(sc.nextInt(),sc.nextInt());
		}
		ArrayList<Meeting> list = getSchedule(meetings);
		System.out.println(list.size());
	}
	static ArrayList<Meeting> getSchedule(Meeting[] meetings){
		
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		
		Arrays.sort(meetings);
		list.add(meetings[0]);
		for(int i = 1,size=meetings.length;i<size;i++) {
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
		
	}
}
