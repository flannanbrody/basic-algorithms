package games;

import java.util.Stack;

public class TowerOfHanoi {

	public static void main(String args[]) {
		Tower[] tower = new Tower[3];
		int n = 3;
		for (int i = 0; i < 3; i++)
			tower[i] = new Tower(i);

		for (int i = n; i > 0; i--)
			tower[0].add(i);
		tower[0].print();
		tower[0].moveDisks(n, tower[2], tower[1]);
		tower[2].print();
	}

	private static class Tower {
		private Stack<Integer> disks;
		private int index;

		public Tower(int i) {
			index = i;
			disks = new Stack<Integer>();
		}

		public int index() {
			return index;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d)
				System.out.println("Error placing disk " + d);
			else
				disks.push(d);
		}

		public void moveTopTo(Tower des) {
			int d = disks.pop();
			des.add(d);
			System.out.println("Moving disk " + d + " from " + index + " to "
					+ des.index());
		}

		public void print() {
			System.out.println("Content of Tower " + index);
			for (int i = disks.size() - 1; i >= 0; i--) {
				System.out.print(disks.get(i) + " ");
			}
			System.out.println();
		}

		public void moveDisks(int n, Tower des, Tower buffer) {
			if (n > 0) {
				moveDisks(n - 1, buffer, des);
				moveTopTo(des);
				buffer.moveDisks(n - 1, des, this);
			}
		}
	}
}
