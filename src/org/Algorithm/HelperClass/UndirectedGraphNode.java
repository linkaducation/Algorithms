package org.Algorithm.HelperClass;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/6/26.
 */
public class UndirectedGraphNode {
	public int label = 0;
	public UndirectedGraphNode left = null;
	public UndirectedGraphNode right = null;
	public ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

	public UndirectedGraphNode(int label) {
		this.label = label;
	}
}
