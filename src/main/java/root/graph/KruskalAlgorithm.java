package root.graph;

import root.structures.UnionFind;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  Minimum spanning tree algorithm
 * 1. Ascending sort all edges by their weight
 * 2. Add edges in that order int MST. Skip the edges that produce cycles in MST
 * 3. Repeat step 2 until N - 1 (N - count of vertex) edges are added
 */
public class KruskalAlgorithm {

	public static int kruskal(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		int size = points.length;
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		UnionFind uf = new UnionFind(size);

		// 1) Asc sort edges by weight
		for (int i = 0; i < size; i++) {
			int[] coordinateA = points[i];
			for (int j = i + 1; j < size; j++) {
				int[] coordinateB = points[j];
				int distance = Math.abs(coordinateB[0] - coordinateA[0]) + Math.abs(coordinateB[1] - coordinateA[1]);
				q.offer(new int[]{i, j, distance});
			}
		}

		int cost = 0;

		// Repeat until N-1 edges added
		int count = size - 1;
		while (!q.isEmpty() && count > 0) {
			int[] edge = q.poll();

			// Add edges to MSP, skip the edges that produce cycle
			if (!uf.connected(edge[0], edge[1])) {
				uf.union(edge[0], edge[1]);
				cost += edge[2];
				count--;
			}
		}
		return cost;
	}
}
