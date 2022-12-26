package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockingTree {

	private int V;
	private int[] parent;
	private int[] locks;
	private List<List<Integer>> children;

	public LockingTree(int[] parent) {
		this.parent = parent;
		this.V = parent.length;
		this.locks = new int[parent.length];
		Arrays.fill(locks, -1);
		this.children = new ArrayList<>();
		for (int i=0; i<V; i++) {
			children.add(i, new ArrayList<>());
		}
		for (int i=0; i<V; i++) {
			if (this.parent[i] != -1) {
				children.get(this.parent[i]).add(i);
			}
		}
	}

	public boolean lock(int num, int user) {
		if (this.locks[num] != -1) {
			return false;
		}
		this.locks[num] = user;
		return true;
	}

	public boolean unlock(int num, int user) {
		if (this.locks[num] == -1 || this.locks[num] != user) {
			return false;
		}
		this.locks[num] = -1;
		return true;
	}

	public boolean upgrade(int num, int user) {
		if (this.locks[num] != -1) {
			return false; // node has to be unlocked
		}
		// all ancestors should be unlocked
		if (anyAncestorLocked(num)) {
			return false;
		}
		// atleast one descendent is locked
		if (allDescendentUnlocked(num)) {
			return false;
		}

		// mark all children node as unlocked
		markAllChildrenUnlocked(num);
		// mark this as locked
		this.locks[num] = user;
		return true;
	}

	private void markAllChildrenUnlocked(int num) {
		for (int child : this.children.get(num)) {
			this.locks[child] = -1;
			markAllChildrenUnlocked(child);
		}
	}

	private boolean allDescendentUnlocked(int num) {
		for (int child : this.children.get(num)) {
			if (this.locks[child] != -1) {
				return false;
			}
			if(!allDescendentUnlocked(child)) return false;
		}
		return true;
	}

	private boolean anyAncestorLocked(int num) {
		while (num != -1) {
			if (this.locks[num] != -1)
				return true;
			num = this.parent[num];
		}
		return false;
	}

	public static void main(String[] args) {
		int[] parent = new int[] {-1, 0, 0, 1, 1, 2, 2};
		LockingTree lockingTree = new LockingTree(parent);
		System.out.println(lockingTree.lock(2, 2));
		System.out.println(lockingTree.unlock(2, 3));
		System.out.println(lockingTree.unlock(2, 2));
		System.out.println(lockingTree.lock(4, 5));
		System.out.println(lockingTree.upgrade(0, 1));
		System.out.println(lockingTree.lock(0, 1));
	}
}
