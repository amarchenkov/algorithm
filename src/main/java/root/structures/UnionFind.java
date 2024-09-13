package root.structures;

/**
 * UnionFind data structure implementation
 * Optimized with "Path Compression" and "Union by Rank"
 */
public class UnionFind {

	private final int[] root;

	private final int[] rank;

	public UnionFind(int size) {
		this.root = new int[size];
		this.rank = new int[size];
		for (int i = 0; i < size; i++) {
			this.root[i] = i;
			this.rank[i] = 1;
		}
	}

	public int find(int node) {
		if (node != root[node]) {
			return node;
		}
		// Path compression
		return root[node] = find(root[node]);
	}

	public void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			if (rank[rootA] > rank[rootB]) {
				root[rootB] = rootA;
			} else if (rank[rootB] > rank[rootA]) {
				root[rootA] = rootB;
			} else {
				root[rootB] = rootA;
				// 2 equal depth tree, root of second become child of the first root -> depth increases by 1
				rank[rootA] += 1;
			}
		}
	}

	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}

}
