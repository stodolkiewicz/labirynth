package algorytmus.labyrinth.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graphs {
    private List<Graph> graphs = new ArrayList<>();

    public Graphs() {
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
}
