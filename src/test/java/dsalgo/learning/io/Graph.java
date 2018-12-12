package dsalgo.learning.io;

import java.util.Iterator;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Graph {
	
	private int vertexCount;
	private LinkedList<Integer>[] adjacency;
	
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		vertexCount = vertices;
		adjacency = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacency[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int vertex, int w) {
		adjacency[vertex].add(w);
	}
	
	public void breadthFirstSearch(int vertex) {
		log.info("| Starting at vertex: {}", vertex);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		
		boolean[] visited = new boolean[vertexCount];
		visited[vertex] = true;
		
		while (queue.size() != 0) {
			int dequedVertex = queue.poll();
			log.info("| Dequeue: {}", dequedVertex);
			
			// find all adjacent vertices
			Iterator<Integer> iter = adjacency[dequedVertex].iterator();
			while (iter.hasNext()) {
				int next = iter.next();
				if (visited[next] != true) {
					log.info("| Queing: {}", next);
					queue.add(next);
				}
			}
		}
	}

}
