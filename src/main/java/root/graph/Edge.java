package root.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {

	private int src;

	private int dst;

	private int weight;

}
