package root.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Topological sort
 * 1) Add all nodes with in-degree 0 to a queue.
 * 2) While the queue is not empty:
 * 2.1) Remove a node from the queue.
 * 2.2) For each outgoing edge from the removed node, decrement the in-degree of the destination node by 1.
 * 2.3) If the in-degree of a destination node becomes 0, add it to the queue.
 * 3) If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
 * 4) The nodes in the queue represent the topological ordering of the graph.
 */
public class KahnAlgorithm {

	public static int[] runKahn(int vertices, List<List<Integer>> adj) {
		// 1
		int[] inDegree = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int it : adj.get(i)) {
				inDegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < vertices; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		int[] result = new int[vertices];
		int index = 0;

		// 2
		while (!q.isEmpty()) {
			// 2.1
			int node = q.poll();
			result[index++] = node;

			// 2.2
			for (int it : adj.get(node)) {
				inDegree[it]--;

				// 2.3
				if (inDegree[it] == 0) {
					q.offer(it);
				}
			}
		}

		// 3
		if (index != vertices) {
			System.err.println("Graph contains cycle!");
			return new int[0];
		}

		// 4
		return result;
	}

}
