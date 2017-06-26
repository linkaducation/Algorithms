package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.HelperClass.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Ellen on 2017/6/26.
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 */
public class CheckPath {

	public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		// write code here
		return check(a, b) || check(b, a);
	}

	public boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
		if (a == null || b == null) {
			return false;
		}
		if (a == b) {
			return true;
		}
		Map<UndirectedGraphNode, Boolean> checkedMap = new HashMap<UndirectedGraphNode, Boolean>();
		LinkedList<UndirectedGraphNode> searchQueue = new LinkedList<UndirectedGraphNode>();
		searchQueue.push(a);
		checkedMap.put(a, true);
		while (!searchQueue.isEmpty()) {
			UndirectedGraphNode currentNode = searchQueue.pop();
			if (currentNode.neighbors != null) {
				for (int i = 0; i < currentNode.neighbors.size(); i++) {
					UndirectedGraphNode neib = currentNode.neighbors.get(i);
					if (neib != null) {
						if (neib == b) {
							return true;
						}
						if (checkedMap.get(neib) == null || !checkedMap.get(neib)) {
							searchQueue.push(neib);
							checkedMap.put(neib, true);
						}
					}
				}
			}
		}
		return false;
	}
}
