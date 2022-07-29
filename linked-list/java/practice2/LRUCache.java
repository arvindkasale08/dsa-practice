package practice2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> cache;
	private Node left;
	private Node right;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.left = new Node(0, 0);
		this.right = new Node(0, 0);
		this.left.next = this.right;
		this.right.prev = this.left;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			remove(cache.get(key));
		}
		cache.put(key, new Node(key, value));
		insert(cache.get(key));

		if (cache.size() > capacity) {
			Node lru = this.left.next;
			remove(lru);
			cache.remove(lru.key);
		}
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			 remove(cache.get(key));
			 insert(cache.get(key));
			 return cache.get(key).value;
		} else {
			return -1;
		}
 	}

	private void remove(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	private void insert(Node node) {
		Node last = this.right.prev;
		last.next = node;
		node.prev = last;
		node.next = this.right;
		this.right.prev = node;
	}

	static class Node {
		private int key;
		private int value;

		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}
