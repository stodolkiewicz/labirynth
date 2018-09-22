package algorytmus.labyrinth;

import algorytmus.labyrinth.algorithm.Algorithm;
import algorytmus.labyrinth.model.Edge;
import algorytmus.labyrinth.model.Vertex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

public class LabyrinthApplication {

	public static void main(String[] args) {

		Vertex vertex1 = new Vertex(0,3, new ArrayList<>());
		Vertex vertex2 = new Vertex(1,3, new ArrayList<>());
		Vertex vertex3 = new Vertex(2,3, new ArrayList<>());
		Vertex vertex4 = new Vertex(0,2, new ArrayList<>());
		Vertex vertex5 = new Vertex(2,2, new ArrayList<>());
		Vertex vertex6 = new Vertex(0,1, new ArrayList<>());
		Vertex vertex7 = new Vertex(2,1, new ArrayList<>());
		Vertex vertex8 = new Vertex(0,0, new ArrayList<>());
		Vertex vertex9 = new Vertex(1,0, new ArrayList<>());
		Vertex vertex10 = new Vertex(2,0, new ArrayList<>());

		vertex1.addAdjacency(new Edge(1, vertex1, vertex2));
		vertex1.addAdjacency(new Edge(1, vertex1, vertex4));

		vertex2.addAdjacency(new Edge(1, vertex2, vertex1));
		vertex2.addAdjacency(new Edge(1, vertex2, vertex3));

		vertex3.addAdjacency(new Edge(1, vertex3, vertex2));
		vertex3.addAdjacency(new Edge(1, vertex3, vertex5));

		vertex4.addAdjacency(new Edge(1, vertex4, vertex1));
		vertex4.addAdjacency(new Edge(1, vertex4, vertex6));

		vertex5.addAdjacency(new Edge(1, vertex5, vertex3));
		vertex5.addAdjacency(new Edge(1, vertex5, vertex7));

		vertex6.addAdjacency(new Edge(1, vertex6, vertex4));
		vertex6.addAdjacency(new Edge(1, vertex6, vertex8));

		vertex7.addAdjacency(new Edge(1, vertex7, vertex5));
		vertex7.addAdjacency(new Edge(1, vertex7, vertex10));

		vertex8.addAdjacency(new Edge(1, vertex8, vertex6));
		vertex8.addAdjacency(new Edge(1, vertex8, vertex9));

		vertex9.addAdjacency(new Edge(1, vertex9, vertex8));
		vertex9.addAdjacency(new Edge(1, vertex9, vertex10));

		vertex10.addAdjacency(new Edge(1, vertex10, vertex7));
		vertex10.addAdjacency(new Edge(1, vertex10, vertex9));

		Algorithm algorithm = new Algorithm();
		algorithm.computePaths(vertex7);

		System.out.println(algorithm.getShortestPathTo(vertex1));
	}
}
