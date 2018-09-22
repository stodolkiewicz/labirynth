package algorytmus.labyrinth;

import algorytmus.labyrinth.dijkstra.DijkstraAlgorithm;
import algorytmus.labyrinth.dijkstra.input.InputHelper;
import algorytmus.labyrinth.dijkstra.input.MapToGraphConverter;
import algorytmus.labyrinth.dijkstra.model.Edge;
import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthApplication {

	public static void main(String[] args) {

//		List<Vertex> vertexList = new ArrayList<>();
//		Vertex vertex1 = new Vertex(0,3, new ArrayList<>());
//		Vertex vertex2 = new Vertex(1,3, new ArrayList<>());
//		Vertex vertex3 = new Vertex(2,3, new ArrayList<>());
//		Vertex vertex4 = new Vertex(0,2, new ArrayList<>());
//		Vertex vertex5 = new Vertex(2,2, new ArrayList<>());
//		Vertex vertex6 = new Vertex(0,1, new ArrayList<>());
//		Vertex vertex7 = new Vertex(2,1, new ArrayList<>());
//		Vertex vertex8 = new Vertex(0,0, new ArrayList<>());
//		Vertex vertex9 = new Vertex(1,0, new ArrayList<>());
//		Vertex vertex10 = new Vertex(2,0, new ArrayList<>());
//
//		vertexList.add(vertex1);
//		vertexList.add(vertex2);
//		vertexList.add(vertex3);
//		vertexList.add(vertex4);
//		vertexList.add(vertex6);
//		vertexList.add(vertex7);
//		vertexList.add(vertex8);
//		vertexList.add(vertex9);
//		vertexList.add(vertex10);
//
//		vertex1.addAdjacency(new Edge(1, vertex1, vertex2));
//		vertex1.addAdjacency(new Edge(1, vertex1, vertex4));
//
//		vertex2.addAdjacency(new Edge(1, vertex2, vertex1));
//		vertex2.addAdjacency(new Edge(1, vertex2, vertex3));
//
//		vertex3.addAdjacency(new Edge(1, vertex3, vertex2));
//		vertex3.addAdjacency(new Edge(1, vertex3, vertex5));
//
//		vertex4.addAdjacency(new Edge(1, vertex4, vertex1));
//		vertex4.addAdjacency(new Edge(1, vertex4, vertex6));
//
//		vertex5.addAdjacency(new Edge(1, vertex5, vertex3));
//		vertex5.addAdjacency(new Edge(1, vertex5, vertex7));
//
//		vertex6.addAdjacency(new Edge(1, vertex6, vertex4));
//		vertex6.addAdjacency(new Edge(1, vertex6, vertex8));
//
//		vertex7.addAdjacency(new Edge(1, vertex7, vertex5));
//		vertex7.addAdjacency(new Edge(1, vertex7, vertex10));
//
//		vertex8.addAdjacency(new Edge(1, vertex8, vertex6));
//		vertex8.addAdjacency(new Edge(1, vertex8, vertex9));
//
//		vertex9.addAdjacency(new Edge(1, vertex9, vertex8));
//		vertex9.addAdjacency(new Edge(1, vertex9, vertex10));
//
//		vertex10.addAdjacency(new Edge(1, vertex10, vertex7));
//		vertex10.addAdjacency(new Edge(1, vertex10, vertex9));
//
//		Graph graph = new Graph();
//		graph.setVertexes(vertexList);
//		graph.setDestinationVertex(vertex1);
//		graph.setSourceVertex(vertex10);
//
//		DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
//		dijkstraAlgorithm.computePaths();
//
//		System.out.println(dijkstraAlgorithm.getShortestPathTo(vertex1));

		InputHelper inputHelper = new InputHelper();
		List<int[][]> listOfMapsFromFile = inputHelper.getListOfMapsFromFile("algorytmus_zadanie_1_input.txt");

		MapToGraphConverter mapToGraphConverter = new MapToGraphConverter();
		for(int i = 0; i < listOfMapsFromFile.size(); i++){
			mapToGraphConverter.convertMapToGraph(listOfMapsFromFile.get(i));
		}


	}
}
