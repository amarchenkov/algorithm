package root.graph;

import java.util.*;

/**
 * Shortest path algorithm
 * 0) Build graph data structure
 * 1) Create a visited boolean array of size = no.of vertices, where each index of the array points to each vertex.
 * 2) Initially, all values in the array are false, depicting no vertex has been visited
 * 3) Then we make a priority queue PrQue, storing objects of type Pair. A pair consisting of 2 data members: vertex and weight to reach that vertex(w).
 * 4) Initially we insert a Pair(sourceVertex, 0) in the priority Queue.
 * 5) Now till PriorityQue is not empty
 * 5.1) Remove the topmost element from the priority queue
 * 5.2) Mark the topmost element as visited
 * 5.3) Now add all the neighbors of topEle to the priority queue only and only if they have not been visited before
 * Time - O(V + E logV)
 * Space -  O(V + E)
 */
public class DijkstraAlgorithm {

	public static int[] runDijkstra(int src, int n, Edge[] edges) {
		// Build graph: V => List of (V + weight)
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.putIfAbsent(i, new ArrayList<>());
		}
		for (Edge edge : edges) {
			graph.get(edge.getSrc()).add(new int[]{edge.getDst(), edge.getWeight()});
		}

		boolean[] visited = new boolean[n];
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.offer(new int[]{src, 0});
		distances[src] = 0;

		while (!pq.isEmpty()) {
			int[] element = pq.poll();
			int v = element[0];
			int weight = element[1];

			if (visited[v]) {
				continue;
			}

			visited[v] = true;

			for (int[] adj : graph.get(v)) {
				int nextNode = adj[0];
				int addWeight = adj[1];
				if (!visited[nextNode] && distances[nextNode] > weight + addWeight) {
					distances[nextNode] = weight + addWeight;
					pq.offer(new int[]{nextNode, distances[nextNode]});
				}
			}

		}
		return distances;
	}

}
