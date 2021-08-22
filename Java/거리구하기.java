import java.util.ArrayList;
import java.util.List;

public class 거리구하기 {

	static class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Point start = new Point(50,25);
		Point dest = new Point(10,30);

		List<Point> list = new ArrayList<>();
		list.add(new Point(100,50));
		list.add(new Point(50,80));
		list.add(new Point(200,100));
		int dis=0;
		for(int i=0;i<list.size();i++) {
			dis += (Math.abs(start.x-list.get(i).x) + Math.abs(start.y-list.get(i).y));
			start = list.get(i);
		}
		dis += (Math.abs(start.x-dest.x) + Math.abs(start.y-dest.y));
		System.out.println(dis);
	}
}
