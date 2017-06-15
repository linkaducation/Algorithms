package org.Algorithm.Chapter9Algorithm;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/6/14.
 */
public class LRUCache {
	class node {
		public node preNode;
		public node postNode;
		public int value;
		public int key;

		public node(int key, int value) {
			this.key = key;
			this.value = value;
			this.preNode = null;
			this.postNode = null;
		}
	}

	int capacity;
	HashMap<Integer, node> map = new HashMap<>(capacity);
	node head = new node(-1, -1);
	node tail = new node(-1, -1);

	public LRUCache(int capacity) {
		// write your code here
		this.capacity = capacity;
		tail.preNode = head;
		head.postNode = tail;
	}

	// @return an integer
	public int get(int key) {
		// write your code here
		if (!map.containsKey(key)) {
			return -1;
		}
		node node = map.get(key);
		node.preNode.postNode = node.postNode;
		node.postNode.preNode = node.preNode;
		moveTotail(node);
		return node.value;
	}

	// @param key, an integer
	// @param value, an integer
	// @return nothing
	public void set(int key, int value) {
		// write your code here
		if (get(key) != -1) {
            node node = map.get(key);
            node.value = value;
            node.preNode.postNode = node.postNode;
            node.postNode.preNode = node.preNode;
            moveTotail(node);
            return;
		}
		if (map.size() == capacity) {
			map.remove(head.postNode.key);
			head.postNode = head.postNode.postNode;
			head.postNode.preNode = head;
		}
		node temp = new node(key, value);
		map.put(key, temp);
		moveTotail(temp);
	}

	public void moveTotail(node node) {
		tail.preNode.postNode = node;
        node.preNode = tail.preNode;
        tail.preNode = node;
        node.postNode = tail;
	}

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
