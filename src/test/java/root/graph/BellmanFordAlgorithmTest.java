package root.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordAlgorithmTest {

	@Test
	void test() {
		int[] distances = BellmanFordAlgorithm.runBellmanFord(0, 4, new Edge[]{
				new Edge(0, 1, 100),
				new Edge(1, 2, 100),
				new Edge(0, 0, 100),
				new Edge(1, 3, 600),
				new Edge(2, 3, 200),
		});
		// 0 - 0
		// 1 - 100
		// 2 - 200
		// 3 - 400
		System.out.println("Finish");
	}

}