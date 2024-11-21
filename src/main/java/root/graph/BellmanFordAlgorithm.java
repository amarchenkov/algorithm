package root.graph;

import java.util.Arrays;

/**
 * Shortest path algorithm
 * <a href="https://habr.com/ru/companies/otus/articles/484382/">Bellman-Ford</a>
 * 1) Initialization - Initialize distances from the source vertex to all other vertices as infinity, except the source vertex itself set to 0.
 * 2) Edge relaxation -Iterate V-1 times, where V is the number of vertices, and relax all edges by updating distances if shorter paths are found.
 * 3) Negative weight cycle detection - Perform an additional iteration to detect negative weight cycles, if any
 * Time - O(V * E)
 * Space - O(V + E)
 */
public class BellmanFordAlgorithm {

	public static int[] runBellmanFord(int src, int n, Edge[] edges) {

		// 1
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;

		// 2
		for (int i = 0; i < n; i++) {
			for (Edge edge : edges) {
				int u = edge.getSrc();
				int v = edge.getDst();
				int weight = edge.getWeight();
				if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
				}
			}
		}

		// 3
		for (Edge edge : edges) {
			int u = edge.getSrc();
			int v = edge.getDst();
			int weight = edge.getWeight();
			if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
				throw new IllegalStateException("Graph contains negative weight cycle");
			}
		}

		// 4
		return distance;
	}

}
