package algorytmus.labyrinth;

import algorytmus.labyrinth.dijkstra.DijkstraAlgorithm;
import algorytmus.labyrinth.dijkstra.input.InputHelper;
import algorytmus.labyrinth.dijkstra.input.MapToGraphConverter;
import algorytmus.labyrinth.dijkstra.model.Edge;
import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Graphs;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthApplication {

	public static void main(String[] args) {
		InputHelper inputHelper = new InputHelper();
		List<int[][]> listOfMapsFromFile = inputHelper.getListOfMapsFromFile("algorytmus_zadanie_1_input.txt");

		MapToGraphConverter mapToGraphConverter = new MapToGraphConverter();

		Graphs graphsWrapper = new Graphs();
		List<Graph> graphs = new ArrayList<>();
		for(int i = 0; i < listOfMapsFromFile.size(); i++){
			Graph graph = mapToGraphConverter.convertMapToGraph(listOfMapsFromFile.get(i));
			mapToGraphConverter.updateAdjacencies(graph);
			graphs.add(graph);
		}

		graphsWrapper.setGraphs(graphs);
		graphsWrapper.computePathsForAllGraphs();
		System.out.println(graphsWrapper.toString());
	}
}
