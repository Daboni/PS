import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 백준9202 {
	public static final int ALPHA_SIZE = 26;
	public static final int MAP_SIZE = 4;

	public static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static int[] scores = new int[] { 0, 0, 0, 1, 1, 2, 3, 5, 11 };

	public static int n;
	public static String[] dict;
	public static char[][] board;

	public static boolean[][] visited;
	public static HashSet<String> candidates;

	public static int ansScore;
	public static String ansString;
	public static int ansNum;

	public static Trie trie;

	public static class Node {
		Node[] child = new Node[ALPHA_SIZE];
		boolean isLastChar = false;
		int childNum;
		char val;
	}

	public static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
			this.root.val = ' ';
		}

		public void insert(String s) {
			Node cur = root;
			int length = s.length();

			for (int i = 0; i < length; i++) {

				char c = s.charAt(i);
				int num = char2int(c);

				if (cur.child[num] == null) {
					cur.child[num] = new Node();
					cur.child[num].val = c;
					cur.childNum++;
				}
				cur = cur.child[num];
			}
			cur.isLastChar = true;
		}

		public int find(String s) {

			Node cur = this.root;
			int length = s.length();

			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				int num = char2int(c);

				if (cur.child[num] == null)
					return -1;
				cur = cur.child[num];
			}

			
			if (cur != null && !cur.isLastChar)
				return 2;
			
			else return 1;
		}

		public int char2int(char c) {
			return c - 'A';
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dict = new String[n];

		trie = new Trie();

		for (int i = 0; i < n; i++) {
			dict[i] = br.readLine();
			trie.insert(dict[i]);
		}
		br.readLine();

		int boardNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < boardNum; i++) {
			board = new char[MAP_SIZE][MAP_SIZE];

			ansScore = 0;
			ansString = "";
			ansNum = 0;
			for (int j = 0; j < MAP_SIZE; j++) {
				String s = br.readLine();
				for (int k = 0; k < MAP_SIZE; k++) {
					board[j][k] = s.charAt(k);
				}
			}
			candidates = new HashSet<>();
			for (int j = 0; j < MAP_SIZE; j++) {
				for (int k = 0; k < MAP_SIZE; k++) {
					visited = new boolean[MAP_SIZE][MAP_SIZE];
					dfs(j, k, "");
				}
			}
			check();
			System.out.println(ansScore + " " + ansString + " " + candidates.size());
			br.readLine();
		}
	}

	public static void dfs(int x, int y, String s) {

		visited[x][y] = true;
		s += board[x][y];

		int tmp = trie.find(s);
		if (tmp == -1)
			return;
		if (tmp == 1)
			candidates.add(s);

		for (int k = 0; k < 8; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (isRange(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, s);
				visited[nx][ny] = false;
			}
		}
	}

	public static boolean isRange(int nx, int ny) {
		if (nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE)
			return false;
		return true;
	}

	public static void check() {

		for (String s : candidates) {

			ansScore += scores[s.length()];
			if (ansString.length() < s.length())
				ansString = s;
			else if (ansString.length() == s.length()) {
				if (ansString.compareTo(s) > 0)
					ansString = s;

			ansNum++;
			}
		}

	}
}
