package algorytmus.labyrinth.dijkstra.model;

import algorytmus.labyrinth.dijkstra.DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Graphs {
    private List<Graph> graphs = new ArrayList<>();
    DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

    public Graphs() {}

    public void computePathsForAllGraphs(){
        graphs.stream()
                .forEach(graph -> {
                    dijkstraAlgorithm.setGraph(graph);
                    dijkstraAlgorithm.computePaths();
                    graph.computeShortestPathToTargetVertex();
                });
    }

    public void addGraph(Graph graph){
        this.graphs.add(graph);
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }

    @Override
    public String toString() {
        String graphsString = "";
        for(Graph graph: graphs){
            graphsString += graph;
        }
        return graphsString;
    }
}
